package com.example.demo.dto;

import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Zahtev;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class AutorDto {

    private boolean aktivnost;
    private Set<Knjiga> spisakKnjiga = new HashSet<Knjiga>();
    private Zahtev zahtevZaAktivacijuNaloga;

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

    public Zahtev getZahtevZaAktivacijuNaloga() {
        return zahtevZaAktivacijuNaloga;
    }

    public void setZahtevZaAktivacijuNaloga(Zahtev zahtevZaAktivacijuNaloga) {
        this.zahtevZaAktivacijuNaloga = zahtevZaAktivacijuNaloga;
    }
}
