package com.example.demo.dto;


import com.example.demo.entity.Korisnik;

import java.time.LocalDate;

public class RegistracijaDto {
    private String ime;
    private String prezime;

    private String korisnickoIme;

    private String mejlAdresa;

    private String lozinka1;

    private String lozinka2;

    private LocalDate datumRodjenja;

    private String profilnaSlika;

    public RegistracijaDto(String ime, String prezime, String korisnickoIme, String mejlAdresa, String lozinka1, LocalDate datumRodjenja, String profilnaSlika) {
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.mejlAdresa = mejlAdresa;
        this.lozinka1 = lozinka1;
        this.datumRodjenja = datumRodjenja;
        this.profilnaSlika = profilnaSlika;
    }
    public RegistracijaDto(Korisnik k){
        this.ime = k.getIme();
        this.prezime = k.getPrezime();
        this.korisnickoIme = k.getKorisnickoIme();
        this.mejlAdresa = k.getMejlAdresa();
        this.lozinka1 = k.getLozinka();
        this.lozinka2 = k.getLozinka();
        this.datumRodjenja = k.getDatumRodjenja();
        this.profilnaSlika = k.getProfilnaSlika();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getMejlAdresa() {
        return mejlAdresa;
    }

    public void setMejlAdresa(String mejlAdresa) {
        this.mejlAdresa = mejlAdresa;
    }

    public String getLozinka1() {
        return lozinka1;
    }

    public void setLozinka1(String lozinka) {
        this.lozinka1 = lozinka;
    }

    public String getLozinka2() {
        return lozinka2;
    }

    public void setLozinka2(String lozinka2) {
        this.lozinka2 = lozinka2;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getProfilnaSlika() {
        return profilnaSlika;
    }

    public void setProfilnaSlika(String profilnaSlika) {
        this.profilnaSlika = profilnaSlika;
    }
}
