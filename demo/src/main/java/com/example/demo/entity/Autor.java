package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.*;


@Entity
public class Autor  extends Korisnik implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean aktivnost;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Knjiga> spisakKnjiga = new HashSet<Knjiga>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    //ova klasa mora biti dete korisnika treba da dodamo metodu i listu


    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", aktivnost=" + aktivnost +
                ", spisakKnjiga=" + spisakKnjiga +
                '}';
    } //pozvati toString iz Korisnika
}
