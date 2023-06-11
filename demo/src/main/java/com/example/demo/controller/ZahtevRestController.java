package com.example.demo.controller;

import com.example.demo.service.AutorService;
import com.example.demo.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.ZahtevDto;

import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Uloga;
import com.example.demo.entity.Status;
import com.example.demo.entity.Autor;

import com.example.demo.entity.Zahtev;
import com.example.demo.service.ZahtevService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ZahtevRestController {


    @Autowired
    private ZahtevService zahtevService;

    @Autowired
    private AutorService autorService;

  // @Autowired
    //private JavaMailSender emailSender;

    @Autowired
    private KorisnikService korisnikService;
/*
    @PostMapping("/api/admin/zahtev/{id}/accept")
    public ResponseEntity<?> zahtevAccept(@PathVariable("id") Long zahtevId, HttpSession session) {
        //Korisnik loggedKorisnik = (Korisnik) session.getAttribute("employee");
        //if(loggedKorisnik.getUloga() == Uloga.ADMINISTRATOR){


            //String meil = zahtev.getEmail();
           // String meilAutora = zahtev.getKorisnik().getMejlAdresa();
           // String loznikaAutora = zahtev.getKorisnik().getLozinka();

            Zahtev zahtev = zahtevService.findOne(zahtevId);
            String meil = zahtev.getEmail();

            zahtev.setStatus(Status.ODOBREN);
            zahtevService.save(zahtev);




            //autorService.kreirajAutora(mejl);

            //Autor autor = autorService.findByMejlAdresa(meil);

           // Long id = zahtev.getKorisnik().getId();
            //Autor autor = autorService.findOne(id);
            //autor.setAktivnost(true);
           // autorService.save(autor);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(meil);
            message.setSubject("Odgovor na zahtev za aktivaciju naloga");
            message.setText("Zahtev je prihvacen!! Uzivajte u pisanju novih knjiga.");

          emailSender.send(message);

            return ResponseEntity.ok("Zahtev je prihvacen, mejl je na putu do vas!!");
*/


       // }else {
           // return new ResponseEntity<>("Niste administrator", HttpStatus.BAD_REQUEST);
       // }
    //}


}
