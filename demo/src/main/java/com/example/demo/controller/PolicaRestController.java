package com.example.demo.controller;

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

@RestController
public class PolicaRestController {

    @Autowired
    private PolicaService policaService;

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
}
