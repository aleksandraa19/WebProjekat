package com.example.demo.repository;

import com.example.demo.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KorisnikRepository  extends JpaRepository<Korisnik, String>{

    List<Korisnik> findAll();
}