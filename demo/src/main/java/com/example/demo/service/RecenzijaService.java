package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Recenzija;
import com.example.demo.repository.RecenzijaRepository;

import java.util.List;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;

    public List<Recenzija> findAll(){
        return recenzijaRepository.findAll();
    }

}
