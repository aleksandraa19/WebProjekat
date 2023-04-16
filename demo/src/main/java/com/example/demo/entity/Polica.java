package com.example.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Polica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String naziv;

    @Column
    private boolean oznaka;  //true - jeste, false - nije

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "polica_id")
    private Set<StavkaPolice> stavkaPolice = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isOznaka() {
        return oznaka;
    }

    public void setOznaka(boolean oznaka) {
        this.oznaka = oznaka;
    }

    public Set<StavkaPolice> getStavkaPolice() {
        return stavkaPolice;
    }

    public void setStavkaPolice(Set<StavkaPolice> stavkaPolice) {
        this.stavkaPolice = stavkaPolice;
    }

    @Override
    public String toString() {
        return "Polica{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", oznaka=" + oznaka +
                ", stavkaPolice=" + stavkaPolice +
                '}';
    }
}
