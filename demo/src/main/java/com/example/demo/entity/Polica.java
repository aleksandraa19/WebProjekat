package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Polica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String naziv;

    @Column
    private boolean oznaka;  //proveri

    //veza sa stavka police



}
