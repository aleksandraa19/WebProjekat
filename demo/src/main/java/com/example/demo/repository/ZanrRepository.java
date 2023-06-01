package com.example.demo.repository;

import com.example.demo.entity.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZanrRepository  extends JpaRepository<Zanr, Long>{
    public List<Zanr> findAll();
}
