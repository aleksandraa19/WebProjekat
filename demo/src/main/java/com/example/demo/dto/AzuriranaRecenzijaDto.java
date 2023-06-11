package com.example.demo.dto;
import com.example.demo.entity.Korisnik;

import java.time.LocalDate;

public class AzuriranaRecenzijaDto {
        private Long id;
        private int ocena;
        private String tekst;
        private LocalDate datum;
        private Korisnik korisnik;

        public AzuriranaRecenzijaDto(Long id, int ocena, String tekst, LocalDate datum, Korisnik korisnik) {
            this.id = id;
            this.ocena = ocena;
            this.tekst = tekst;
            this.datum = datum;
            this.korisnik = korisnik;
        }

        public Long getId() { return id; }

        public void setId(Long id) { this.id = id; }

        public int getOcena() { return ocena; }

        public void setOcena(int ocena) { this.ocena = ocena; }

        public String getTekst() { return tekst; }

        public void setTekst(String tekst) { this.tekst = tekst; }

        public LocalDate getDatum() { return datum; }

        public void setDatum(LocalDate datum) { this.datum = datum; }

        public Korisnik getKorisnik() { return korisnik; }

        public void setKorisnik(Korisnik korisnik) { this.korisnik = korisnik; }
}
