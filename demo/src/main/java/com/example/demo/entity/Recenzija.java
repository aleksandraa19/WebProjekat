package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Recenzija implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double ocena;

    @Column
    private String text;

    @Column
    private Long datumRecenzije;

    //veza sa korisnikom

}
