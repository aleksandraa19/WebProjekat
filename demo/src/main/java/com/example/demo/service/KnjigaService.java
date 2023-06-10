package com.example.demo.service;

import com.example.demo.entity.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Knjiga;
import com.example.demo.repository.KnjigaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class KnjigaService {

    @Autowired
    private KnjigaRepository knjigaRepository;

    public List<Knjiga> findAll() {
        return knjigaRepository.findAll();
    }

//    public List<Knjiga> findByKorisnik(Korisnik korisnik) {
//        return knjigaRepository.findByKorisnik(korisnik);
//    }

    public Knjiga getKnjigaByName(String name) {

        List<Knjiga> knjige = findAll();

        for (Knjiga k : knjige) {
            if (k.getNaslov().equals(name)) {
                return k;
            }
        }
        return null;
    }
    public Knjiga getKnjigaById(Long id){
        List<Knjiga> knjige = findAll();

        for (Knjiga k : knjige) {
            if (k.getId() == id) {
                return k;
            }
        }
        return null;
    }
}
