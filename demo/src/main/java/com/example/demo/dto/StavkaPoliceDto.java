package com.example.demo.dto;

import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Recenzija;
import java.util.HashSet;
import java.util.Set;

public class StavkaPoliceDto {
    private Knjiga knjiga;

    private Set<Recenzija> recenzije = new HashSet<>();
}
