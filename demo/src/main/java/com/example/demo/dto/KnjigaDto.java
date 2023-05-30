package com.example.demo.dto;

import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Zanr;

import javax.persistence.*;
import java.time.LocalDate;

public class KnjigaDto {
    private String naslov;
    private String naslovnaFotografija;
    private String ISBN;
    private LocalDate datumObjavljivanja;
    private int brStrana;
    private String opis;
    private Zanr zanr;
    private double ocena;


    public KnjigaDto(){}

    public KnjigaDto(String naslov, String naslovnaFotografija,String ISBN,LocalDate datumObjavljivanja,int brStrana,String opis,Zanr zanr,double ocena){
        this.naslov = naslov;
        this.naslovnaFotografija = naslovnaFotografija;
        this.ISBN = ISBN;
        this.datumObjavljivanja = datumObjavljivanja;
        this.brStrana = brStrana;
        this.opis = opis;
        this.zanr = zanr;
        this.ocena = ocena;

    }

    public KnjigaDto(Knjiga k){
        this.naslov = k.getNaslov();
        this.naslovnaFotografija = k.getNaslovnaFotografija();
        this.ISBN = k.getISBN();
        this.datumObjavljivanja = k.getDatumObjavljivanja();
        this.brStrana = k.getBrStrana();
        this.opis = k.getOpis();
        this.zanr = k.getZanr();
        this.ocena = k.getOcena();
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslovnaFotografija() {
        return naslovnaFotografija;
    }

    public void setNaslovnaFotografija(String naslovnaFotografija) {
        this.naslovnaFotografija = naslovnaFotografija;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public LocalDate getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public void setDatumObjavljivanja(LocalDate datumObjavljivanja) {
        this.datumObjavljivanja = datumObjavljivanja;
    }

    public int getBrStrana() {
        return brStrana;
    }

    public void setBrStrana(int brStrana) {
        this.brStrana = brStrana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }
}
