package com.example.demo.controller;

import com.example.demo.dto.KnjigaDto;
import com.example.demo.dto.StavkaPoliceDto;
import com.example.demo.entity.Knjiga;
import com.example.demo.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.StavkaPolice;
import com.example.demo.service.StavkaPoliceService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StavkaPoliceRestController {

    @Autowired
    private StavkaPoliceService stavkaPoliceService;

    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("/api/stavkapolice/{naslov}")
    public ResponseEntity<List<StavkaPoliceDto>> getKnjigaPoNaslovu(@PathVariable(name = "naslov")String naslov){



        Knjiga k = knjigaService.getKnjigaByName(naslov);

        if(k == null){
            return ResponseEntity.notFound().build();
        }

        Long id = k.getId();

        List<StavkaPolice> sp = stavkaPoliceService.dobaviStavku(id);
        List<StavkaPoliceDto> dtos = new ArrayList<>();
        for(StavkaPolice s: sp){
            StavkaPoliceDto dto = new StavkaPoliceDto(s);
            dtos.add(dto);
        }


        return ResponseEntity.ok(dtos);

    }

}
