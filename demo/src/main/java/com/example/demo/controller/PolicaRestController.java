package com.example.demo.controller;

import com.example.demo.dto.KnjigaDto;
import com.example.demo.entity.Korisnik;
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

}
