package com.example.demo.dto;

import com.example.demo.entity.Zanr;

public class ZanrDto {

    private String naziv;

    public String getNaziv() {
        return naziv;
    }

    public ZanrDto(Zanr zanr) {
        this.naziv = zanr.getNaziv();
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
