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

    public void save(Knjiga k){
        knjigaRepository.save(k);
    }

    public Long napraviKnjigu(String naslov, int brstrana, String isbn, LocalDate datum, String foto,String opis, double ocena){
        Knjiga knjiga = new Knjiga();
        knjiga.setNaslov(naslov);
        knjiga.setOpis(opis);
        knjiga.setDatumObjavljivanja(datum);
        knjiga.setBrStrana(brstrana);
        knjiga.setNaslovnaFotografija(foto);
        knjiga.setOcena(ocena);
        knjiga.setISBN(isbn);

        knjigaRepository.save(knjiga);
        return knjiga.getId();
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
