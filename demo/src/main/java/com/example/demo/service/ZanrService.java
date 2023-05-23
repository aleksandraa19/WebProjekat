package com.example.demo.service;

import com.example.demo.entity.Autor;
import com.example.demo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Zanr;
import com.example.demo.repository.ZanrRepository;

import java.util.List;

@Service
public class ZanrService {

    @Autowired
    private ZanrRepository zanrRepository;

    public List<Zanr> findAll(){
        return zanrRepository.findAll();
    }

}
