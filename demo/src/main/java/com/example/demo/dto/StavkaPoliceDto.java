package com.example.demo.dto;

import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Recenzija;
import com.example.demo.entity.StavkaPolice;

import java.util.HashSet;
import java.util.Set;

public class StavkaPoliceDto {
    private Knjiga knjiga;

    private Set<Recenzija> recenzije = new HashSet<>();

    public StavkaPoliceDto(){}

    public StavkaPoliceDto(Knjiga knjiga, Set<Recenzija> recenzije){
        this.knjiga = knjiga;
        this.recenzije = recenzije;
    }

    public StavkaPoliceDto(StavkaPolice sv){
        this.knjiga = sv.getKnjiga();
        this.recenzije = sv.getRecenzije();
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Set<Recenzija> getRecenzije() {
        return recenzije;
    }

    public void setRecenzije(Set<Recenzija> recenzije) {
        this.recenzije = recenzije;
    }
}
