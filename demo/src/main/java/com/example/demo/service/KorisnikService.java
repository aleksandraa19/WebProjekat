package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Korisnik;
import com.example.demo.repository.KorisnikRepository;

import java.util.List;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }

}
