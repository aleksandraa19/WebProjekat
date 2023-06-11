package com.example.demo.service;

import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Zanr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Knjiga;
import com.example.demo.repository.KnjigaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Service
public class KnjigaService {

    @Autowired
    private KnjigaRepository knjigaRepository;

    public List<Knjiga> findAll() {
        return knjigaRepository.findAll();
    }


    /*public List<Knjiga> findByKorisnik(Korisnik korisnik) {
        return knjigaRepository.findByKorisnik(korisnik);
    }*/

    public Knjiga getKnjigaByName(String name) {

        List<Knjiga> knjige = findAll();

        for (Knjiga k : knjige) {
            if (k.getNaslov().equals(name)) {
                return k;
            }
        }
        return null;
    }

    public void napraviKnjigu(String naslov, int brstrana, String isbn, Zanr zanr, LocalDate datum, String foto,String opis){

        Knjiga knjiga = new Knjiga();
        knjiga.setBrStrana(brstrana);
        knjiga.setISBN(isbn);
        knjiga.setNaslov(naslov);
        knjiga.setOpis(opis);
        knjiga.setDatumObjavljivanja(datum);
        knjiga.setNaslovnaFotografija(foto);
        knjiga.setZanr(zanr);

        //knjigaRepository.save(knjiga);

    }

    public void save(Knjiga k){
        knjigaRepository.save(k);
    }


}
