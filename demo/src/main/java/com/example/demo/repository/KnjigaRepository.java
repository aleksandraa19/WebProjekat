package com.example.demo.repository;

import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Korisnik;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnjigaRepository  extends JpaRepository<Knjiga, Long>{

    Knjiga findById(long Id);
<<<<<<< Updated upstream
=======

    List<Knjiga> findByKorisnik(Korisnik korisnik);

    Knjiga getByNaslov(String naslov);
>>>>>>> Stashed changes
}