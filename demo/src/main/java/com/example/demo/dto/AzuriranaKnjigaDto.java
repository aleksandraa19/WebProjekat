package com.example.demo.dto;

import java.time.LocalDate;

public class AzuriranaKnjigaDto {
        private String naslov;
        private String naslovnaFotografija;
        private String isbn;
        private LocalDate datumObjavljivanja;
        private int brojStrana;
        private String opis;
        private Long zanrId;

        public AzuriranaKnjigaDto(String naslov, String naslovnaFotografija, String isbn, LocalDate datumObjavljivanja, int brojStrana, String opis, Long zanrId) {
            this.naslov = naslov;
            this.naslovnaFotografija = naslovnaFotografija;
            this.isbn = isbn;
            this.datumObjavljivanja = datumObjavljivanja;
            this.brojStrana = brojStrana;
            this.opis = opis;
            this.zanrId = zanrId;
        }
        public AzuriranaKnjigaDto() {
        }

        public String getNaslov() {
            return naslov;
        }

        public void setNaslov(String naslov) {
            this.naslov = naslov;
        }

        public String getNaslovnaFotografija() {
            return naslovnaFotografija;
        }

        public void setNaslovnaFotografija(String naslovnaFotografija) {
            this.naslovnaFotografija = naslovnaFotografija;
        }

        public String getISBN() {
            return isbn;
        }

        public void setISBN(String ISBN) {
            this.isbn = ISBN;
        }

        public LocalDate getDatumObjavljivanja() {
            return datumObjavljivanja;
        }

        public void setDatumObjavljivanja(LocalDate datumObjavljivanja) {
            this.datumObjavljivanja = datumObjavljivanja;
        }

        public int getBrojStrana() {
            return brojStrana;
        }

        public void setBrojStrana(int brojStrana) {
            this.brojStrana = brojStrana;
        }

        public String getOpis() {
            return opis;
        }

        public void setOpis(String opis) {
            this.opis = opis;
        }

        public Long getZanrId() {
            return zanrId;
        }

        public void setZanrId(Long zanrId) {
            this.zanrId = zanrId;
        }
}
