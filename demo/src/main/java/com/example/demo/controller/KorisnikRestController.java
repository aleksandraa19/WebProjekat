package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
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
    public ResponseEntity Logout(HttpSession session){

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if(loggedKorisnik == null){
            return new ResponseEntity("Forbidden" , HttpStatus.FORBIDDEN);
        }

        session.invalidate();
        return new ResponseEntity("Successfully logged out", HttpStatus.OK);

    }




}
