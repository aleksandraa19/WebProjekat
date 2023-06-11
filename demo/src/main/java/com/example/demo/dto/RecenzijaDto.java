package com.example.demo.dto;

import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Recenzija;

import java.time.LocalDate;

public class RecenzijaDto {
    private Long id;
    private double ocena;
    private String text;
    private LocalDate datumRecenzije;

    private Korisnik korisnik;


    public RecenzijaDto(Long id, double ocena, String tekst, LocalDate datum, Korisnik korisnik) {
        this.id = id;
        this.ocena = ocena;
        this.text = tekst;
        this.datumRecenzije = datum;
        this.korisnik = korisnik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDatumRecenzije() {
        return datumRecenzije;
    }

    public void setDatumRecenzije(LocalDate datumRecenzije) {
        this.datumRecenzije = datumRecenzije;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
