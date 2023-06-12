package com.example.demo.dto;

//import com.example.demo.entity.Status;

import com.example.demo.entity.Status;
import com.example.demo.entity.Zahtev;

//import jdk.vm.ci.meta.Local;


import java.time.LocalDate;

public class ZahtevDto {


    private String email;
    private String telefon;
    private String poruka;

    private LocalDate datum;

    //private Status status;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }


//    public String getDatum() {
//        return datum;
//    }
//
//    public void setDatum(String datum) {
//        this.datum = datum;
//    }
   public ZahtevDto(){}
    public ZahtevDto(Zahtev z) {
        ZahtevDto zahtev = null;
        zahtev.setEmail(z.getEmail());
        zahtev.setTelefon(z.getTelefon());
        zahtev.setPoruka(z.getPoruka());
        //zahtev.setStatus(z.getStatus(););
    }
    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;

    }
}
