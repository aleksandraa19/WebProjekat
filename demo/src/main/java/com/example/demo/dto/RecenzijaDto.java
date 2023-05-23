package com.example.demo.dto;

import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Recenzija;

public class RecenzijaDto {
    private double ocena;
    private String text;
    private String datumRecenzije;
    private Korisnik korisnik;

    public RecenzijaDto(Recenzija recenzija) {
        this.ocena = recenzija.getOcena();
        this.text = recenzija.getText();
        this.datumRecenzije = recenzija.getDatumRecenzije();
        this.korisnik = recenzija.getKorisnik();
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

    public String getDatumRecenzije() {
        return datumRecenzije;
    }

    public void setDatumRecenzije(String datumRecenzije) {
        this.datumRecenzije = datumRecenzije;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
