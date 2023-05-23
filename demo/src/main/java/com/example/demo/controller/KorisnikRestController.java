package com.example.demo.controller;

import com.example.demo.dto.RegistracijaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Korisnik;
import com.example.demo.service.KorisnikService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class KorisnikRestController {

    @Autowired
    private KorisnikService korisnikService;

    @PostMapping("api/registracija")
    public ResponseEntity<String> registracija(@RequestBody RegistracijaDto registracijaDto, HttpSession session){
        if(registracijaDto.getIme().isEmpty() || registracijaDto.getPrezime().isEmpty() || registracijaDto.getMejlAdresa().isEmpty() || registracijaDto.getKorisnickoIme().isEmpty() || registracijaDto.getLozinka1().isEmpty() || registracijaDto.getLozinka2().isEmpty()){
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
        }
        List<Korisnik> sviKorisnici = korisnikService.findAll();
        for(Korisnik k: sviKorisnici){
            if(k.getKorisnickoIme().equals(registracijaDto.getKorisnickoIme())){
                return new ResponseEntity("Korisnik pod tim korisnickim imenom vec postoji!", HttpStatus.BAD_REQUEST);
            }
            if(k.getMejlAdresa().equals(registracijaDto.getMejlAdresa())){
                return new ResponseEntity("Korisnik sa mejl adresom vec postoji!", HttpStatus.BAD_REQUEST);
            }
        }
        if(!registracijaDto.getLozinka1().equals(registracijaDto.getLozinka2())){
            return new ResponseEntity("Greska prilikom unosa lozinke", HttpStatus.CONFLICT);
        }
        //korisnikService.saveKorisnik();
        Korisnik registrovan = korisnikService.registracija(registracijaDto.getKorisnickoIme(), registracijaDto.getIme(), registracijaDto.getPrezime(), registracijaDto.getLozinka1(), registracijaDto.getMejlAdresa(), registracijaDto.getDatumRodjenja(),registracijaDto.getProfilnaSlika());
        session.setAttribute("korisnik", registrovan);
        return ResponseEntity.ok("Korisnik je registrovan");
    }
}
