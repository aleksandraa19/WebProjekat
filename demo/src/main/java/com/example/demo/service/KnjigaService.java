package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Knjiga;
import com.example.demo.repository.KnjigaRepository;

import java.util.List;

@Service
public class KnjigaService {

    @Autowired
    private KnjigaRepository knjigaRepository;

    public List<Knjiga> findAll(){
        return knjigaRepository.findAll();
    }
}
