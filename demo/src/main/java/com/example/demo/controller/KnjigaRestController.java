package com.example.demo.controller;

import com.example.demo.dto.KnjigaDto;
import com.example.demo.entity.Zanr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Knjiga;
import com.example.demo.service.KnjigaService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class KnjigaRestController {

    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("/api/knjiga/{zanr}")
    public ResponseEntity<List<KnjigaDto>> getKnjiga(@PathVariable(name = "zanr")Zanr zanr, HttpSession session){
        List<Knjiga> knjige = knjigaService.findAll();
        List<KnjigaDto> trazene = new ArrayList<>();
        for(Knjiga k: knjige){
            if(k.getZanr() == zanr){
                KnjigaDto dto = new KnjigaDto(k);
                trazene.add(dto);
            }
        }
        return ResponseEntity.ok(trazene);
    }

}
