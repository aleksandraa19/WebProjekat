package com.example.demo.service;


import com.example.demo.dto.KnjigaDto;
import com.example.demo.entity.Knjiga;

import com.example.demo.entity.Recenzija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.StavkaPolice;
import com.example.demo.repository.StavkaPoliceRepository;

import java.util.List;
import java.util.Set;

@Service
public class StavkaPoliceService {

    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    @Autowired
    private KnjigaService knjigaService;


    public List<StavkaPolice> findAll(){
        return stavkaPoliceRepository.findAll();
    }

//    public  List<StavkaPolice> findByKnjigaId(Long id){
//
//        Set<StavkaPolice> stavke =
//    }

    public StavkaPolice save(StavkaPolice sp){ return stavkaPoliceRepository.save(sp);}

   public List<StavkaPolice> dobaviStavku(Long knjigaId){
        return stavkaPoliceRepository.findByKnjigaId(knjigaId);
    }



}
