package com.example.demo.dto;

public class DodatZanrDto {
        private String naziv;

        public DodatZanrDto(String naziv) {
            this.naziv = naziv;
        }
        public DodatZanrDto(){}

        public String getNaziv() {
            return naziv;
        }

        public void setNaziv(String naziv) {
            this.naziv = naziv;
        }
}
