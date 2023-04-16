package com.example.demo.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
public class Autor  extends Korisnik implements Serializable{

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
        String s =  "Autor{" +
                "id = " + getId() +
                ", ime =" + getIme() +
                ", aktivnost=" + aktivnost +
                ", spisakKnjiga=";
        /*for(Knjiga k: spisakKnjiga){
            s += k.toString();
        }*/
                s+='}';
        return s;
    } //pozvati toString iz Korisnika
}
