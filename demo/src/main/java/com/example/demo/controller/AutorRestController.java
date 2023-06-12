package com.example.demo.controller;

import com.example.demo.dto.KnjigaDto;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Uloga;
import com.example.demo.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Autor;
import com.example.demo.service.AutorService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AutorRestController {
    @Autowired
    private AutorService autorService;
    @Autowired
    private KnjigaService knjigaService;

    @PostMapping("/api/autor/dodajKnjige")
    public ResponseEntity<String> napraviKnjigu(@RequestBody KnjigaDto knjigaDto, HttpSession session) {

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        Long userId = null;

        if (loggedKorisnik == null) {
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!",HttpStatus.UNAUTHORIZED);
        } else {
            userId = loggedKorisnik.getId();

        }

        if(loggedKorisnik.getUloga() != Korisnik.Uloga.AUTOR){
            return new ResponseEntity("Nemate odobrenje, samo autor moze da dodati knjigu!", HttpStatus.BAD_REQUEST);
        }


        Knjiga k = null;
        knjigaService.napraviKnjigu(knjigaDto.getNaslov(),knjigaDto.getBrStrana(),knjigaDto.getISBN(),knjigaDto.getZanr(),knjigaDto.getDatumObjavljivanja(),knjigaDto.getNaslovnaFotografija(),knjigaDto.getOpis());

        boolean daLi = autorService.sadrzi(k,userId);

        if (daLi){
            return new ResponseEntity("Ovu knjigu ste vec dodali!", HttpStatus.BAD_REQUEST);
        }

        knjigaService.save(k);
        autorService.dodadKnjiguUListu(k,userId);

        return ResponseEntity.ok("Kreirali ste novu knjigu!");

    }
}
