package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;


@Entity
public class Knjiga  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naslov;

    @Column
    private String naslovnaFotografija;

    @Column(unique = true)
    private String ISBN;

    @Column
    private LocalDate datumObjavljivanja;

    @Column
    private int brStrana;

    @Column
    private String opis;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "zanr_id")
    private Zanr zanr;

    @Column
    private double ocena;

    public Knjiga(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public LocalDate getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public void setDatumObjavljivanja(LocalDate DatumObjavljivanja) {
        datumObjavljivanja = DatumObjavljivanja;
    }

    public int getBrStrana() {
        return brStrana;
    }

    public void setBrStrana(int brStrana) {
        this.brStrana = brStrana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public String getNaslovnaFotografija() {
        return naslovnaFotografija;
    }

    public void setNaslovnaFotografija(String naslovnaFotografija) {
        this.naslovnaFotografija = naslovnaFotografija;
    }

    @Override
    public String toString() {
        return "Knjiga{" +
                "id=" + id +
                ", naslov='" + naslov + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", datumObjavljivanja='" + datumObjavljivanja + '\'' +
                ", brStrana=" + brStrana +
                ", opis='" + opis + '\'' +
                ", zanr=" + zanr.getNaziv() +
                ", ocena=" + ocena +
                '}';
    }
}
