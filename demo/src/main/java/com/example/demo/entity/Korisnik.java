package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


private enum Uloga {CITALAC, AUTOR, ADMINISTRATOR}

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Korisnik  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;

    @Column
    private String prezime;


    @Column(unique = true)
    private String korisnickoIme;  //jedinstven

    @Column(unique = true)
    private String mejlAdresa;  //jedinstven


    @Column
    private String lozinka;

    @Column
    private LocalDate datumRodjenja;

    @Column
    private String profilnaSlika;

    //lista polica da se doda
    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "korisnik_id")
    private Set<Polica> listaPolica = new HashSet<>();

    /*private Polica WantToRead= new Polica("Want to read", true);
    private Polica CurrentlyReading= new Polica("Currently reading", true);
    private Polica Read = new Polica("Read", true);*/


    @Column
    private String opis;


    @Column
    @Enumerated(value = EnumType.STRING)
    private Uloga uloga;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
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

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", mejlAdresa='" + mejlAdresa + '\'' +
                ", datumRodjenja='" + datumRodjenja + '\'' +
                ", lista polica= " + listaPolica +  '\'' +
                ", opis='" + opis + '\'' +
                ", uloga=" + uloga +
                '}';
    }
}
