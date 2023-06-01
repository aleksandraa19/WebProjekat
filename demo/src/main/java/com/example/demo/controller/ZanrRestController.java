package com.example.demo.controller;


import com.example.demo.dto.ZanrDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Zanr;
import com.example.demo.service.ZanrService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ZanrRestController {


    @Autowired
    private ZanrService zanrService;

    @GetMapping("api/zanrovi")
    public ResponseEntity<List<ZanrDto>> getZanrovi(){
        List<ZanrDto> trazeni = new ArrayList<>();
        List<Zanr> zanrovi = zanrService.findAll();

        for(Zanr z: zanrovi){
            ZanrDto dto = new ZanrDto(z);
            trazeni.add(dto);
        }
        return ResponseEntity.ok(trazeni);
    }
}
