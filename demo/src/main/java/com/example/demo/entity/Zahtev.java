package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;


enum Status{NACEKANJU,ODOBREN,ODBIJEN}

@Entity
public class Zahtev implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private Long telefon;

    @Column
    private String poruka;

    @Column
    private Long Datum;

    @Column
    private Status status;


}
