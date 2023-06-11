package com.example.demo.controller;

import com.example.demo.dto.ZahtevDto;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Status;
import com.example.demo.entity.Uloga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Zahtev;
import com.example.demo.service.ZahtevService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ZahtevRestController {


    @Autowired
    private ZahtevService zahtevService;

    @GetMapping("/api/zahtev/getZahtevi")
    ResponseEntity<List<ZahtevDto>> listaZahteva(HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if (korisnik == null) {
            System.out.println("Nema sesije");
            return ResponseEntity.badRequest().build();
        }
        if(korisnik.getUloga() == Korisnik.Uloga.ADMINISTRATOR){
            List<Zahtev> sviZahtevi = zahtevService.findAll();
            List<ZahtevDto> trazeni = null;
            for(Zahtev z: sviZahtevi){
                if(z.getStatus() == Status.NACEKANJU){
                    ZahtevDto zahtev = new ZahtevDto(z);
                    trazeni.add(zahtev);
                }
            }
            return ResponseEntity.ok(trazeni);
        }
        System.out.println("Samo admin moze videti zahteve");
        return null;
    }
    @PostMapping("/api/zahtev/posalji")
    ResponseEntity<String> posaljiZahtev(@RequestBody ZahtevDto zahtevDto){
        Zahtev zahtev = new Zahtev();
        zahtev.setEmail(zahtevDto.getEmail());
        zahtev.setTelefon(zahtevDto.getTelefon());
        zahtev.setPoruka(zahtevDto.getPoruka());
        zahtev.setStatus(Status.NACEKANJU);
        zahtevService.save(zahtev);
        return ResponseEntity.ok("Zahtev je poslat!");
    }
}
