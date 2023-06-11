package com.example.demo.repository;

import com.example.demo.entity.Knjiga;
import com.example.demo.entity.StavkaPolice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StavkaPoliceRepository  extends JpaRepository<StavkaPolice, Long>{

    @Override
    List<StavkaPolice> findAll();
//    StavkaPolice save(StavkaPolice sp);
    List<StavkaPolice> findByKnjigaId(Long id);

}