package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class StavkaPolice implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //veza sa recenzijom i knjigom

}
