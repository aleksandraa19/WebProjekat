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

    public Polica savePolica(Polica p){return policaRepository.save(p);}


    public Polica  napraviPolicu(String naziv){

       /* List<Polica> policas = policaRepository.findAll();

        for(Polica po: policas){
            if(po.getNaziv().equals(naziv)){
                return null;
            }

        }*/

        Polica p = new Polica();
        p.setNaziv(naziv);
        p.setOznaka(false);
        policaRepository.save(p);
        return p;
    }

    public boolean obrisiPolicu(Long id){

      List<Polica> police =  policaRepository.findAll();

        for(Polica p: police){
            if(p.getId() == id){
                    policaRepository.deleteById(p.getId());
                    return true;
            }

        }
        return false;

    }



}
