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

    @ManyToMany
    @JoinTable( name = "police",
            joinColumns = @JoinColumn(name = "stavka_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "stavkaPolice_id", referencedColumnName = "id"))
    private Set<StavkaPolice> stavkaPolice = new HashSet<>();

    public Polica(String naziv, boolean oznaka){
        this.naziv = naziv;
        this.oznaka = oznaka;
    }
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
        String s = "Polica{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", oznaka=" + oznaka;
               //", stavkaPolice=";
       /* for(StavkaPolice sp: stavkaPolice){
            s += sp.toString();
        }*/
                s+='}';
        return s;
    }
}
