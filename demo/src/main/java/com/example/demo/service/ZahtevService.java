package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Zahtev;
import com.example.demo.repository.ZahtevRepository;

import java.util.List;

@Service
public class ZahtevService {
    @Autowired
    private ZahtevRepository zahtevRepository;

    public List<Zahtev> findAll(){
        return zahtevRepository.findAll();
    }

}
