package com.example.demo.dto;

import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Polica;
//import com.example.demo.entity.Uloga;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class KorisnikDto {
    private Long id;
    private String ime;

    private String prezime;

    private String korisnickoIme;

    private LocalDate datumRodjenja;

    private String profilnaSlika;

    private Set<Polica> listaPolica = new HashSet<>();

    private String opis;

    private Korisnik.Uloga uloga;
    public KorisnikDto(){}

    public KorisnikDto(String ime,String prezime,String korisnickoIme,LocalDate datumRodjenja,String profilnaSlika,Set<Polica> listaPolica, Korisnik.Uloga uloga){
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.datumRodjenja = datumRodjenja;
        this.profilnaSlika = profilnaSlika;
        this.listaPolica = listaPolica;
        this.uloga = uloga;
    }


    public KorisnikDto(Korisnik korisnik){
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.korisnickoIme = korisnik.getKorisnickoIme();
        this.datumRodjenja = korisnik.getDatumRodjenja();
        this.profilnaSlika = korisnik.getProfilnaSlika();
        this.listaPolica = korisnik.getListaPolica();
        this.uloga = korisnik.getUloga();
    }

    //private Uloga uloga;

    public KorisnikDto(String ime, String prezime, String korisnickoIme, LocalDate datumRodjenja, String profilnaSlika, Set<Polica> listaPolica, String opis) {
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.datumRodjenja = datumRodjenja;
        this.profilnaSlika = profilnaSlika;
        this.listaPolica = listaPolica;
        this.opis = opis;
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

    public Set<Polica> getListaPolica() {
        return listaPolica;
    }

    public void setListaPolica(Set<Polica> listaPolica) {
        this.listaPolica = listaPolica;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Korisnik.Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Korisnik.Uloga uloga) {
        this.uloga = uloga;
    }
}
