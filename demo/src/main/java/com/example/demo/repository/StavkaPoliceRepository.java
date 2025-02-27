package com.example.demo.repository;

import com.example.demo.entity.StavkaPolice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StavkaPoliceRepository  extends JpaRepository<StavkaPolice, Long>{

    @Override
    List<StavkaPolice> findAll();
}