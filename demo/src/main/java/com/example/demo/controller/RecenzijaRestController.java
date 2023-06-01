package com.example.demo.controller;

import com.example.demo.dto.RecenzijaDto;
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

}
