package com.example.demo.controller;

import com.example.demo.dto.KnjigaDto;

import com.example.demo.entity.Zanr;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.PolicaDto;
import com.example.demo.entity.*;
import com.example.demo.service.PolicaService;
import com.example.demo.service.StavkaPoliceService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/api/dodajknjigu")
    public ResponseEntity<String> dodajKnjigu(@RequestBody KnjigaDto knjiga, @RequestBody PolicaDto polica, HttpSession session) {
        Korisnik citalac = (Korisnik) session.getAttribute("korisnik");
        if (citalac == null) {
            System.out.println("Nema sesije");
            return ResponseEntity.badRequest().build();
        }

        List<Knjiga> knjige = knjigaService.findByKorisnik(citalac);
        List<Polica> police = policaService.findByKorisnik(citalac);
        Set<StavkaPolice> stavke = null;
        for (Polica p : police) {
            if (p.getNaziv().equals("Read") || p.getNaziv().equals("Want to Read") || p.getNaziv().equals("Currently Reading")) {
                stavke = p.getStavkaPolice();
                for (StavkaPolice sp : stavke) {
                    if (sp.getKnjiga().getNaslov().equals(knjiga.getNaslov())) {
                        return ResponseEntity.ok("Knjiga je vec dodata na primarnu");
                    }
                }
            }

        }
        return ResponseEntity.ok("Knjiga je vec dodata");
    }

//        for (Knjiga k: knjige){
//            if(k.getNaslov().equals(knjiga.getNaslov())){
//                for(Polica p: police) {
//                    if (p.getNaziv().equals("Read") || p.getNaziv().equals("Want to Read") || p.getNaziv().equals("Currently Reading")) {
//                        if(stavke.contains(p.getStavkaPolice()))
//                            return ResponseEntity.ok("Knjiga je vec dodata na primarnu");
//                    }
//                }
//            } else {
//                //knjigaService.
//            }
//        }


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
