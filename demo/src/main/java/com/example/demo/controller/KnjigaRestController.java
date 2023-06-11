package com.example.demo.controller;

import com.example.demo.dto.KnjigaDto;

import com.example.demo.dto.KorisnikDto;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Zanr;


import com.example.demo.dto.LoginDto;
import com.example.demo.dto.PolicaDto;
import com.example.demo.entity.*;

import com.example.demo.service.KorisnikService;
import com.example.demo.service.PolicaService;
import com.example.demo.service.StavkaPoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.service.KnjigaService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class KnjigaRestController {

    @Autowired
    private KnjigaService knjigaService;

    @Autowired
    private PolicaService policaService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private StavkaPoliceService stavkaPoliceService;


    @GetMapping("/api/knjiga/{zanr}")
    public ResponseEntity<List<KnjigaDto>> getKnjiga(@PathVariable(name = "zanr")Zanr zanr, HttpSession session){
        List<Knjiga> knjige = knjigaService.findAll();
        List<KnjigaDto> trazene = new ArrayList<>();
        for(Knjiga k: knjige){
            if(k.getZanr() == zanr){
                KnjigaDto dto = new KnjigaDto(k);
                trazene.add(dto);
            }
        }
        return ResponseEntity.ok(trazene);
    }
    @PostMapping("/api/knjiga/{knjigaId}/dodajKnjiguNaPolicu/{policaId}")
    public ResponseEntity<String> dodajKnjiguNaPolicu(@PathVariable(name = "knjigaId") Long knjigaId,@PathVariable(name = "policaId") Long policaId, HttpSession session) {
        Korisnik citalac = (Korisnik) session.getAttribute("korisnik");
        if (citalac == null) {
            System.out.println("Nema sesije");
            return ResponseEntity.badRequest().build();
        }
        if(!(citalac.getUloga() == Uloga.CITALAC || citalac.getUloga() == Uloga.AUTOR)){
            return ResponseEntity.badRequest().body("Ne mozete pristupiti, niste citalac, ni autor!");
        }
        boolean primarna = policaService.daLiJePrimarna(policaId);
        //List<Knjiga> knjige = knjigaService.findByKorisnik(citalac);
        Set<Polica> police = policaService.findByKorisnik(citalac);
        Set<StavkaPolice> stavke = null;
        Knjiga knjiga = knjigaService.getKnjigaById(knjigaId);
        Polica polica = policaService.findByIdKorisnikove(policaId,police);

        if(primarna){
             Polica nadjena = policaService.findPrimarnu(police,knjiga);
             if(nadjena == null){
                 return ResponseEntity.badRequest().body("Greska");
             }
             if(nadjena.getId() == policaId){
                 return ResponseEntity.badRequest().body("Knjiga je vec dodata na policu");
             }
             try {
                policaService.dodajKnjiguNaPolicu(knjigaId,policaId);
             } catch (ChangeSetPersister.NotFoundException e) {
                throw new RuntimeException(e);
             }
             //policaService.obrisiKnjiguSaPolice(knjigaId,nadjena.getId());
        }
//        if(primarna){
//            for(Polica p: police){
//                stavke = p.getStavkaPolice();
//                for (StavkaPolice sp : stavke) {
//                    if (sp.getKnjiga().getNaslov().equals(knjiga.getNaslov())) {
//                        return ResponseEntity.ok("Knjiga je vec dodata na primarnu");
//                    }
//                }
//            }
//        } else{
//            for(Polica p2: police){
//                if (p2.getNaziv().equals("Read") || p2.getNaziv().equals("Want to Read") || p2.getNaziv().equals("Currently Reading")){
//                    stavke = p2.getStavkaPolice();
//                    for (StavkaPolice sp : stavke) {
//                        if (sp.getKnjiga().getNaslov().equals(knjiga.getNaslov())) {
//                            Polica novaPolica = null;
//                            novaPolica = policaService.napraviPolicu(polica.getNaziv());
//                            korisnikService.dodajPolicu(citalac.getId(),novaPolica);
//                            policaService.dodajKnjiguNaPolicu(knjiga,citalac,polica);
//                            return ResponseEntity.ok("Knjiga je uspesno dodata na policu.");
//                        } else{
//                            return ResponseEntity.ok("Knjiga se mora dodati prvo na primarnu policu.");
//                        }
//                    }
//                }
//            }
//        }
        return ResponseEntity.badRequest().body("Knjiga ne postoji u bazi!");
    }


    @GetMapping("/api/knjige/{naslov}")
    public ResponseEntity<KnjigaDto> getKnjigaPoNaslovu(@PathVariable(name = "naslov")String naslov){

        Knjiga k = knjigaService.getKnjigaByName(naslov);


        if(k == null){
            return ResponseEntity.notFound().build();
        }

        KnjigaDto dto = new KnjigaDto(k);
        return ResponseEntity.ok(dto);

    }

    @GetMapping("/api/knjige")
    public ResponseEntity<List<KnjigaDto>> getKnjige(){

        List<Knjiga> listaknjiga = knjigaService.findAll();

        if(listaknjiga.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        List<KnjigaDto> dtos = new ArrayList<>();
        for(Knjiga k: listaknjiga){
            KnjigaDto dto = new KnjigaDto(k);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }






}
