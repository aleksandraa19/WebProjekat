package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Knjiga  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String Naslov;

    //naslovna fotografija nez tip

    @Column
    private Long ISBN;

    @Column
    private int DatumObjavljivanja;  //ili mzd string

    @Column
    private int brStrana;

    @Column
    private String opis;

    @Column
    private Zanr zanr;

    @Column
    private double ocena;

}
