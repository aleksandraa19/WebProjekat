package com.example.demo.service;

import com.example.demo.dto.DodatZanrDto;
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

    public Zanr findById(Long id) { return zanrRepository.findZanrById(id);}

    public Zanr save(Zanr z) { return zanrRepository.save(z); }
    public Zanr kreiraj(DodatZanrDto zanrAddDto) {
        Zanr zanr = new Zanr();
        zanr.setNaziv(zanrAddDto.getNaziv());
        return save(zanr);
    }
}
