package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Autor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //ova klasa mora biti dete korisnika treba da dodamo metodu i listu
    //garic poslao link sa nasledjivanjem toga





}
