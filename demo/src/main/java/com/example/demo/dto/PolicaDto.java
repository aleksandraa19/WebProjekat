package com.example.demo.dto;

import com.example.demo.entity.StavkaPolice;
import java.util.HashSet;
import java.util.Set;

public class PolicaDto {
    private String naziv;
    private boolean oznaka;
    private Set<StavkaPolice> stavkaPolice = new HashSet<>();

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
}
