package com.example.demo.dto;

import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Zahtev;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class AzuriranAutorDto {
    private boolean aktivnost;
    private Set<Knjiga> spisakKnjiga = new HashSet<Knjiga>();

    private String ime;

    private String prezime;

    private String korisnickoIme;

    private LocalDate datumRodjenja;

    private String profilnaSlika;

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

    public boolean isAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(boolean aktivnost) {
        this.aktivnost = aktivnost;
    }

    public Set<Knjiga> getSpisakKnjiga() {
        return spisakKnjiga;
    }

    public void setSpisakKnjiga(Set<Knjiga> spisakKnjiga) {
        this.spisakKnjiga = spisakKnjiga;
    }

}
