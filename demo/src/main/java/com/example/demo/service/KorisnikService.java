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


    public Korisnik login(String korisnickoIme, String sifra){
        Korisnik korisnik = korisnikRepository.getByKorisnickoIme(korisnickoIme);



        if(korisnik == null || !korisnik.getLozinka().equals(sifra)){
            return null;
        }
        return korisnik;
    }


    public Korisnik findOne(String username){
        Korisnik korisnik = korisnikRepository.getByKorisnickoIme(username);

        if(korisnik == null){
            return null;
        }

        return korisnik;
    }




}
