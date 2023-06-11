package com.example.demo.controller;


import com.example.demo.dto.RegistracijaDto;

import com.example.demo.dto.LoginDto;
import com.example.demo.service.PolicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Korisnik;
import com.example.demo.service.KorisnikService;


import javax.servlet.http.HttpSession;
import java.time.LocalDate;
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
        Korisnik registrovan = null;
        registrovan = korisnikService.registracija(registracijaDto.getKorisnickoIme(), registracijaDto.getIme(), registracijaDto.getPrezime(), registracijaDto.getLozinka1(), registracijaDto.getMejlAdresa(), registracijaDto.getDatumRodjenja(),registracijaDto.getProfilnaSlika());
        korisnikService.saveKorisnik(registrovan);
        session.setAttribute("korisnik", registrovan);
        return ResponseEntity.ok("Korisnik je registrovan");
    }



    @PostMapping("api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto,HttpSession session){

        if(loginDto.getKorisnickoIme().isEmpty() || loginDto.getLozinka().isEmpty()){
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
        }


        Korisnik loggedKorisnik = korisnikService.login(loginDto.getKorisnickoIme(), loginDto.getLozinka());
        if(loggedKorisnik == null){
            return new ResponseEntity<>("User does not exist!", HttpStatus.NOT_FOUND);
        }

        session.setAttribute("korisnik",loggedKorisnik);
        return ResponseEntity.ok("Successfully logged in!");

    }

    @PostMapping("api/logout")
    public ResponseEntity<String> Logout(HttpSession session){

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if(loggedKorisnik == null){
            return new ResponseEntity("Forbidden" , HttpStatus.FORBIDDEN);
        }

        session.invalidate();
        return new ResponseEntity("Successfully logged out", HttpStatus.OK);

    }


    @GetMapping("/api/korisnici/{korisnickoIme}")
    public Korisnik getKorisnik(@PathVariable(name = "korisnickoIme")String korisnickoIme){

        Korisnik korisnik = korisnikService.findOne(korisnickoIme);

        if(korisnik == null){
            return null;
        }

        return korisnik;

    }


    @PutMapping("/api/korisnik/azurirajime/{ime}")
    public ResponseEntity<String> AzurirajIme(@PathVariable(name = "ime") String ime,HttpSession session){

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        Long userId = null;

        if(loggedKorisnik == null){
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!!",HttpStatus.UNAUTHORIZED);
        }else{
            userId = loggedKorisnik.getId();
        }

        korisnikService.AzurirajIme(ime,userId);
        return ResponseEntity.ok("Ime je azurirano");

    }

    @PutMapping("/api/korisnik/azurirajPrezime/{prezime}")
    public ResponseEntity<String> AzurirajPrezime(@PathVariable(name = "prezime")String prezime, HttpSession session){

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        Long userId = null;

        if(loggedKorisnik == null){
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!!",HttpStatus.UNAUTHORIZED);
        }else{
            userId = loggedKorisnik.getId();
        }

        korisnikService.AzurirajPrezime(prezime,userId);
        return ResponseEntity.ok("Prezime je azurirano");


    }


    @PostMapping("/api/korisnik/dodajRodjendan/{datumRodjenja}")
    public ResponseEntity<String> DodajRodjendan(@PathVariable(name = "datumRodjenja")String datumRodjenja, HttpSession session){

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        Long userId = null;

        if(loggedKorisnik == null){
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!!",HttpStatus.UNAUTHORIZED);
        }else{
            userId = loggedKorisnik.getId();

        }

        LocalDate datum = LocalDate.parse(datumRodjenja);

        korisnikService.DodajDatum(datum,userId);
        return ResponseEntity.ok("Datum rodjenja je dodat!!");

    }

    @PostMapping("/api/korisnik/dodajOpis/{opis}")
    public ResponseEntity<String> dodajOpis(@PathVariable(name = "opis")String opis, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        Long userId = null;

        if(loggedKorisnik == null){
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!!",HttpStatus.UNAUTHORIZED);
        }else{
            userId = loggedKorisnik.getId();

        }

        korisnikService.DodajOpis(opis,userId);
        return ResponseEntity.ok("Opis je dodat");



    }


    @PutMapping("/api/korisnik/AzuriranjeSifre")
    public ResponseEntity<String> AzurirajSifru(@RequestParam String sifra, @RequestParam String trenutnaLozinka,HttpSession session){


        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        Long userId = null;

        if(loggedKorisnik == null){
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!!",HttpStatus.UNAUTHORIZED);
        }else{
            userId = loggedKorisnik.getId();

        }

        if(sifra.isEmpty() ){
            return new ResponseEntity("Niste uneli novu sifru", HttpStatus.BAD_REQUEST);
        }else if(trenutnaLozinka.isEmpty()){
            return new ResponseEntity("Unesite trenutnu sifru!", HttpStatus.BAD_REQUEST);
        }

        boolean daLi = korisnikService.proveriSifru(trenutnaLozinka,userId);


        if(daLi){
            korisnikService.MenjajSifru(sifra,userId);
            return ResponseEntity.ok("Sifra je promenjena.");
        }

        return new ResponseEntity("Losa trenutna sifra. Pokusajte ponovo!" , HttpStatus.FORBIDDEN);

    }


   @PutMapping("/api/korisnik/menjajMejl")
    public ResponseEntity<String> promenaMejla(@RequestParam String mejl, @RequestParam String trenutnasifra,HttpSession session){


       Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

       Long userId = null;

       if(loggedKorisnik == null){
           //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
           return new ResponseEntity<>("Nema sesije. Ulogujte se!!",HttpStatus.UNAUTHORIZED);
       }else{
           userId = loggedKorisnik.getId();

       }

       if(mejl.isEmpty() ){
           return new ResponseEntity("Niste uneli novi mejl!", HttpStatus.BAD_REQUEST);
       }else if(trenutnasifra.isEmpty()){
           return new ResponseEntity("Unesite trenutnu sifru!", HttpStatus.BAD_REQUEST);
       }


       boolean daLi = korisnikService.proveriSifru(trenutnasifra,userId);


       if(daLi){
           korisnikService.MenjajMejl(mejl,userId);
           return ResponseEntity.ok("Mejl je promenjen.");
       }


       return new ResponseEntity("Pogresna trenutna sifra!!" , HttpStatus.FORBIDDEN);

   }






}
