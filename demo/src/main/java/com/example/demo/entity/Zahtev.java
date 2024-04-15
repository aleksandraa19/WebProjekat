package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;


@Entity
public class Zahtev implements Serializable{
    //public enum Status {NACEKANJU, ODOBREN, ODBIJEN}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String telefon;

    @Column
    private String poruka;

    @Column
    private LocalDate datum;

    @Column
    @Enumerated(value = EnumType.STRING)
    public Status status;

    @OneToOne
    private Korisnik korisnik;

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Zahtev() {}
//    public String getDatum() {
//        return datum;
//    }
//
//    public void setDatum(String Datum) {
//        datum = Datum;
//    }
    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;

    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;

    }

    @Override
    public String toString() {
        return "Zahtev{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", poruka='" + poruka + '\'' +
                ", datum='" + datum + '\'' +
                ", status=" + status +
                '}';
    }

}
