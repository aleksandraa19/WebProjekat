package com.example.demo.repository;

import com.example.demo.entity.Recenzija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecenzijaRepository  extends JpaRepository<Recenzija, Long>{

    Recenzija findRecenzijaByDatumRecenzije(String dr);

    @Override
    List<Recenzija> findAll();
}