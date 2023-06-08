package com.example.demo.service;

import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.StavkaPolice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Polica;
import com.example.demo.repository.PolicaRepository;

import java.util.List;
import java.util.Set;

@Service
public class PolicaService {

    @Autowired
    private PolicaRepository policaRepository;

    public List<Polica> findAll(){
        return policaRepository.findAll();
    }

    public Polica save(Polica p) { return policaRepository.save(p); }

    public void dodajKnjiguNaPolicu(Knjiga knjiga, Korisnik korisnik, Polica polica){
        Set<Polica> lista = korisnik.getListaPolica();
        Set<StavkaPolice> stavke = null;
        for(Polica p: lista){
            if(p.getNaziv().equals("Want to Read") || p.getNaziv().equals("Currently Reading") || p.getNaziv().equals("Read")){
                stavke = p.getStavkaPolice();


            }
        }
    }
}
