package com.example.demo.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
public class Autor extends Korisnik implements Serializable{

    @Column
    private boolean aktivnost;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Set<Knjiga> spisakKnjiga = new HashSet<Knjiga>();

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

    //ova klasa mora biti dete korisnika treba da dodamo metodu i listu


    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + getId() +
                ", ime='" + getIme() + '\'' +
                ", prezime='" + getPrezime() + '\'' +
                ", korisnickoIme='" + getKorisnickoIme() + '\'' +
                ", mejlAdresa='" + getMejlAdresa() + '\'' +
                ", datumRodjenja='" + getDatumRodjenja() + '\'' +
                ", opis='" + getOpis() + '\'' +
                ", uloga=" + getUloga() +
                "= { aktivnost = "+ aktivnost +
                "} }";
    }
}
