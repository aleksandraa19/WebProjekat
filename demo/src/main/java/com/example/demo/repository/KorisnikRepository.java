package com.example.demo.repository;

import com.example.demo.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KorisnikRepository  extends JpaRepository<Korisnik, String>{

    List<Korisnik> findAll();

    Korisnik save(Korisnik k);

    Korisnik findById(Long id);

    Boolean existsByMejlAdresa(String mail);
    Boolean existsByLozinka(String mail);
    Boolean existsByKorisnickoIme(String mail);

    Korisnik getByKorisnickoIme(String korisnickoIme);







}