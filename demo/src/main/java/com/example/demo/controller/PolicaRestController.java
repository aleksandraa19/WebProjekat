package com.example.demo.controller;


import com.example.demo.dto.KnjigaDto;
import com.example.demo.entity.Korisnik;

import com.example.demo.dto.PolicaDto;
import com.example.demo.entity.Korisnik;
import com.example.demo.service.KorisnikService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Polica;
import com.example.demo.service.PolicaService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class PolicaRestController {

    @Autowired
    private PolicaService policaService;


//    @PostMapping("/api/dodajnapolicu")
//    public ResponseEntity<String> dodajNaPolice(@RequestBody KnjigaDto knjiga, HttpSession session){
//        Korisnik citalac = (Korisnik) session.getAttribute("korisnik");
//        if(citalac == null){
//            System.out.println("Nema sesije");
//            return ResponseEntity.badRequest().build();
//        }
//        Set<Polica> primarne = citalac.getListaPolica();
//    }

    @Autowired
    private KorisnikService korisnikService;

    /*@PostMapping("api/registracija")
    public ResponseEntity<String> registracija(@RequestBody RegistracijaDto registracijaDto, HttpSession session)*/


    @PostMapping("/api/pravipolice")
    public ResponseEntity<String> novePolice(@RequestBody PolicaDto policaDto, HttpSession session){

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        Long userId = null;

        if(loggedKorisnik == null){
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!!",HttpStatus.UNAUTHORIZED);
        }else{
          userId = loggedKorisnik.getId();
        }

        Polica polica = null;
        polica = policaService.napraviPolicu(policaDto.getNaziv());

        policaService.savePolica(polica);
       boolean daLi = korisnikService.dodajPolicu(userId,polica);

       if(!daLi){
           return new ResponseEntity<>("Vec postoji polica sa tim nazivom",HttpStatus.BAD_REQUEST);
       }

        return ResponseEntity.ok("Polica je dodata");



    }


    @DeleteMapping("/api/police/brisi")
    public ResponseEntity<String> brisipolice(@RequestBody PolicaDto policaDto, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        Long userId = null;

        if(loggedKorisnik == null){
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!!",HttpStatus.UNAUTHORIZED);
        }else{
            userId = loggedKorisnik.getId();
        }

        Polica polica = korisnikService.obrisiPolicuizListe(userId, policaDto.getNaziv());

        if(polica == null){
            return new ResponseEntity<>("Polica ne postoji ili pokusavate da uklonite primarnu policu",HttpStatus.BAD_REQUEST);
        }


        boolean daLi = policaService.obrisiPolicu(polica.getId());

        if(daLi == false){
            return new ResponseEntity<>("Polica nije uklonjena iz baze",HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok("Polica je obrisana");




    }




}
