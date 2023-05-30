package com.example.demo.controller;

import com.example.demo.dto.KnjigaDto;
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


    @GetMapping("/api/knjige/{naslov}")
    public ResponseEntity<KnjigaDto> getKnjigaPoNaslovu(@PathVariable(name = "naslov")String naslov){

        Knjiga k = knjigaService.getKnjigaByName(naslov);

        if(k == null){
            return ResponseEntity.notFound().build();
        }

        KnjigaDto dto = new KnjigaDto(k);
        return ResponseEntity.ok(dto);

    }

    @GetMapping("/api/knjige")
    public ResponseEntity<List<KnjigaDto>> getKnjige(){

        List<Knjiga> listaknjiga = knjigaService.findAll();

        if(listaknjiga.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        List<KnjigaDto> dtos = new ArrayList<>();
        for(Knjiga k: listaknjiga){
            KnjigaDto dto = new KnjigaDto(k);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }



}
