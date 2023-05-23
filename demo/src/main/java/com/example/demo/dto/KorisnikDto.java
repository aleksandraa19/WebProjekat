package com.example.demo.dto;

import com.example.demo.entity.Polica;
//import com.example.demo.entity.Uloga;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class KorisnikDto {
    private String ime;

    private String prezime;

    private String korisnickoIme;

    private LocalDate datumRodjenja;

    private String profilnaSlika;

    private Set<Polica> listaPolica = new HashSet<>();

    /*private Polica WantToRead= new Polica("Want to read", true);
    private Polica CurrentlyReading= new Polica("Currently reading", true);
    private Polica Read = new Polica("Read", true);*/

    private String opis;

    //private Uloga uloga;

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

//    public Uloga getUloga() {
//        return uloga;
//    }
//
//    public void setUloga(Uloga uloga) {
//        this.uloga = uloga;
//    }
}
