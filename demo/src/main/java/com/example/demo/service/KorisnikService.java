package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Korisnik;
import com.example.demo.repository.KorisnikRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }
    public Korisnik saveKorisnik(Korisnik k) { return korisnikRepository.save(k);}
    public Korisnik registracija(String korisnickoIme, String ime, String prezime, String lozinka1, String mejl, LocalDate datumRodjenja, String profilnaSlika){
        Korisnik k = new Korisnik();
        k.setIme(ime);
        k.setPrezime(prezime);
        k.setKorisnickoIme(korisnickoIme);
        k.setLozinka(lozinka1);
        k.setMejlAdresa(mejl);
        k.setDatumRodjenja(datumRodjenja);
        k.setProfilnaSlika(profilnaSlika);
        korisnikRepository.save(k);
        return k;
    }
}
