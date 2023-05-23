package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Polica;
import com.example.demo.repository.PolicaRepository;

import java.util.List;

@Service
public class PolicaService {

    @Autowired
    private PolicaRepository policaRepository;

    public List<Polica> findAll(){
        return policaRepository.findAll();
    }
}
