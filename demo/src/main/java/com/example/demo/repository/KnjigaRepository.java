package com.example.demo.repository;

import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.StavkaPolice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnjigaRepository  extends JpaRepository<Knjiga, Long>{

    Knjiga findById(long Id);

    Knjiga save(Knjiga knjiga);

    void deleteById(Long id);
    Knjiga getByNaslov(String naslov);
    //List<Knjiga> findByKorisnik(Korisnik korisnik);



    //List<StavkaPolice> findByKnjigaId(Long id);

}