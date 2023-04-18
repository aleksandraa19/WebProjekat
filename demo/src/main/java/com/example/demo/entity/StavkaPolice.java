package com.example.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class StavkaPolice implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "knjiga_id")
    private Knjiga knjiga;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "stavka_id")
    private Set<Recenzija> recenzije = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Set<Recenzija> getRecenzije() {
        return recenzije;
    }

    public void setRecenzije(Set<Recenzija> recenzije) {
        this.recenzije = recenzije;
    }

    @Override
    public String toString() {
        return "StavkaPolice{" +
                "id=" + id +
                ", knjiga=" + knjiga.toString() +
                ", recenzije=" + recenzije +
                '}';
    }
}
