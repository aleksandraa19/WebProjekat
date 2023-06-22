package com.example.demo.controller;


import com.example.demo.dto.DodatZanrDto;
import com.example.demo.dto.ZanrDto;
import com.example.demo.entity.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Zanr;
import com.example.demo.service.ZanrService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ZanrRestController {


    @Autowired
    private ZanrService zanrService;

    @GetMapping("api/zanrovi")
    @CrossOrigin
    public ResponseEntity<List<ZanrDto>> getZanrovi(){
        List<ZanrDto> trazeni = new ArrayList<>();
        List<Zanr> zanrovi = zanrService.findAll();

        for(Zanr z: zanrovi){
            ZanrDto dto = new ZanrDto(z);
            trazeni.add(dto);
        }
        return ResponseEntity.ok(trazeni);
    }

    @PostMapping("/api/dodajZanr")
    public ResponseEntity<?> dodajZanr(@RequestBody DodatZanrDto zanrAddDto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik.getUloga() == Korisnik.Uloga.ADMINISTRATOR){
            zanrService.kreiraj(zanrAddDto);
            return new ResponseEntity<>("Zanr added seccessfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("You are not administrator", HttpStatus.BAD_REQUEST);
        }
    }
}
