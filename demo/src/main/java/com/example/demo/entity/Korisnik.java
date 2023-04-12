package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

enum Uloga {CITALAC, AUTOR, ADMINISTRATOR}

@Entity
public class Korisnik  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String korisnickoIme;  //jedinstven

    @Column
    private String mejlAdresa;  //jedinstven


    @Column
    private String lozinka;

    @Column
    private Long datumRodjenja;  //long  ili string

    //profilna slika nez tip

    @Column
    private String opis;


    @Column
    private Uloga uloga;



}
