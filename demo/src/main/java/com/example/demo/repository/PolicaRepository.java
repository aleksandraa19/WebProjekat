package com.example.demo.repository;

import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Polica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicaRepository  extends JpaRepository<Polica, Long>{

    List<Polica> findAll();


    Polica save(Polica polica);

    //Polica findById(Long id);
    //List<Polica> findByKorisnik(Korisnik korisnik);


    void deleteById(Long id);




}