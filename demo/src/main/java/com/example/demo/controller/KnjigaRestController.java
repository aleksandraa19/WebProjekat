package com.example.demo.controller;

import com.example.demo.dto.KnjigaDto;
<<<<<<< Updated upstream
=======

import com.example.demo.dto.LoginDto;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Polica;
>>>>>>> Stashed changes
import com.example.demo.entity.Zanr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Knjiga;
import com.example.demo.service.KnjigaService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class KnjigaRestController {

    @Autowired
    private KnjigaService knjigaService;

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

<<<<<<< Updated upstream
=======
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
    @PostMapping("/api/dodajknjigu")
    public ResponseEntity<String> dodajKnjigu(@RequestBody KnjigaDto knjiga, HttpSession session){
        Korisnik citalac = (Korisnik) session.getAttribute("korisnik");
        if(citalac == null){
            System.out.println("Nema sesije");
            return ResponseEntity.badRequest().build();
        }
        List<Knjiga> knjige = knjigaService.findByKorisnik(citalac);
        for (Knjiga k: knjige){
            if(k.getNaslov().equals(knjiga.getNaslov())){
                return ResponseEntity.ok("Knjiga je vec dodata")
            } else {
                //knjigaService.
            }
        }
    }

>>>>>>> Stashed changes
}
