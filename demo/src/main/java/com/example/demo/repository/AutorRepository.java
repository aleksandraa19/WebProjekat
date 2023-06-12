package com.example.demo.repository;


import com.example.demo.entity.Autor;
import com.example.demo.entity.Zahtev;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository  extends JpaRepository<Autor, String>{
    List<Autor> findAll();


    Autor findByMejlAdresa(String mejl);

    Autor save(Autor a);

}