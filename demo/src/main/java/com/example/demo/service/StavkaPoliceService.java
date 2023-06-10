package com.example.demo.service;

import com.example.demo.dto.KnjigaDto;
import com.example.demo.entity.Knjiga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.StavkaPolice;
import com.example.demo.repository.StavkaPoliceRepository;

import java.util.List;

@Service
public class StavkaPoliceService {

    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    public List<StavkaPolice> findAll(){
        return stavkaPoliceRepository.findAll();
    }
    public  List<StavkaPolice> findByKnjigaId(Long id){
        return stavkaPoliceRepository.findByKnjigaId(id);
    }
//    public StavkaPolice dodajKnjigu(Knjiga knjiga){
//
//    }
}
