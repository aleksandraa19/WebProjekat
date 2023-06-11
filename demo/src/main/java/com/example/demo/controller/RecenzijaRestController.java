package com.example.demo.controller;

import com.example.demo.dto.RecenzijaDto;
import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Korisnik;
import com.example.demo.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Recenzija;
import com.example.demo.service.RecenzijaService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecenzijaRestController {

    @Autowired
    private RecenzijaService recenzijaService;
    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("api/recenzije")
    public ResponseEntity<List<RecenzijaDto>> getRecenzije(){
        List<Recenzija> recenzije = recenzijaService.findAll();
        List<RecenzijaDto> recenzijaDtoList = new ArrayList<>();
        for(Recenzija r: recenzije){
            RecenzijaDto dto = new RecenzijaDto(r);
            recenzijaDtoList.add(dto);
        }
        return ResponseEntity.ok(recenzijaDtoList);
    }

    @PostMapping("/api/recenzije/dodajRecenziju/{knjigaId}")
    public ResponseEntity<String> dodajRecenziju (@PathVariable(name = "knjigaId")Long id,@PathVariable(name =  "policaNaziv")String naziv, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if (korisnik == null) {
            System.out.println("Nema sesije");
            return ResponseEntity.badRequest().build();
        }
        Knjiga knjiga = knjigaService.getKnjigaById(id);
        if(naziv.equals("Read")){
            //dodaj
            return ResponseEntity.ok("Recenzija dodata");
        } else{
            return ResponseEntity.badRequest().body("Recenzija se moze dodati ako je knjiga na Read polici.");
        }
    }

}
