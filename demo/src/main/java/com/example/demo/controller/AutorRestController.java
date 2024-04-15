package com.example.demo.controller;

import com.example.demo.dto.KnjigaDto;
import com.example.demo.dto.ZahtevDto;
import com.example.demo.dto.AzuriranAutorDto;
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
import java.util.Set;

@RestController
public class AutorRestController {
    @Autowired
    private AutorService autorService;
    @Autowired
    private KnjigaService knjigaService;
//prebaci u knjigarest
    @PostMapping("/api/autor/dodajKnjige")
    @CrossOrigin
    public ResponseEntity<String> napraviKnjigu(@RequestBody KnjigaDto knjigaDto, HttpSession session) {

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        Long userId = null;

        if (loggedKorisnik == null) {
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!",HttpStatus.UNAUTHORIZED);
        } else {
            userId = loggedKorisnik.getId();

        }

        if(loggedKorisnik.getUloga() != Korisnik.Uloga.AUTOR && loggedKorisnik.getUloga() != Korisnik.Uloga.ADMINISTRATOR){
            return new ResponseEntity("Nemate odobrenje, samo autor i admin moze da dodati knjigu!", HttpStatus.BAD_REQUEST);
        }

        Knjiga k = knjigaService.kreirajKnjigu(knjigaDto.getNaslov(),knjigaDto.getBrStrana(),knjigaDto.getISBN(),knjigaDto.getZanr(),knjigaDto.getDatumObjavljivanja(),knjigaDto.getNaslovnaFotografija(),knjigaDto.getOpis());

        boolean daLi = autorService.sadrzi(k,userId);

        if (daLi){
            return new ResponseEntity("Ovu knjigu ste vec dodali!", HttpStatus.BAD_REQUEST);
        }

        //knjigaService.save(k);
        autorService.dodadKnjiguUListu(k,userId);
        return ResponseEntity.ok("Kreirali ste novu knjigu!");

    }
    @PostMapping("/api/dodajAutora")
    public ResponseEntity<?> dodajAutora(@RequestBody ZahtevDto zahtev, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        Long userId = null;

        if (loggedKorisnik == null) {
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!",HttpStatus.UNAUTHORIZED);
        } else {
            userId = loggedKorisnik.getId();

        }
        if(loggedKorisnik.getUloga() == Korisnik.Uloga.ADMINISTRATOR){
            Autor a = new Autor();
            a.setAktivnost(false);
            a.setMejlAdresa(zahtev.getEmail());
            a.setUloga(Korisnik.Uloga.AUTOR);
            autorService.save(a);
            return ResponseEntity.ok("Autor je kreiran");
        }

        return ResponseEntity.badRequest().body("Niste administrator, ne mozete dodati autora");
    }
    @PutMapping("/api/azurirajAutora")
    @CrossOrigin
    public ResponseEntity<?> azurirajAutora(@RequestBody AzuriranAutorDto autor, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        Long userId = null;

        if (korisnik == null) {
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!",HttpStatus.UNAUTHORIZED);
        } else {
            userId = korisnik.getId();

        }
        if(korisnik.getUloga() == Korisnik.Uloga.AUTOR || korisnik.getUloga() == Korisnik.Uloga.ADMINISTRATOR){
             autorService.azuriraj(autor,userId);
            return ResponseEntity.ok("Autor je azuriran!");
        }
        return ResponseEntity.badRequest().body("Doslo je do greske, samo autor i administrator moze azurirati");
    }

    @DeleteMapping("/api/brisiKnjigu/{knjigaId}")
    public ResponseEntity<?> obrisiSvojeKnjige(@PathVariable Long knjigaId, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        Long userId = null;

        if (loggedKorisnik == null) {
            //return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>("Nema sesije. Ulogujte se!",HttpStatus.UNAUTHORIZED);
        } else {
            userId = loggedKorisnik.getId();

        }
        Knjiga knjiga = knjigaService.getKnjigaById(knjigaId);

        if(loggedKorisnik.getUloga() != Korisnik.Uloga.AUTOR && loggedKorisnik.getUloga() != Korisnik.Uloga.ADMINISTRATOR){
            return new ResponseEntity("Nemate odobrenje, samo autor i admin mogu da obrisati knjigu!", HttpStatus.BAD_REQUEST);
        }
        if(loggedKorisnik.getUloga() == Korisnik.Uloga.AUTOR){
            Autor autor = autorService.findOne(userId);
            Set<Knjiga> njegoveKnjige = autor.getSpisakKnjiga();
            if(njegoveKnjige.contains(knjiga)){
                njegoveKnjige.remove(knjiga);
//                List<Knjiga> sveUBazi = knjigaService.findAll();
//                sveUBazi.remove(knjiga);
                knjigaService.obrisiIzBaze(knjigaId);

                return ResponseEntity.ok("Knjiga je obrisana");
            }
        }

            knjigaService.obrisiIzBaze(knjigaId);
            return ResponseEntity.ok("Knjiga je obrisana");


    }
//    @PutMapping
//    public ResponseEntity<?> azurirajAktivnost(@RequestBody )
}
