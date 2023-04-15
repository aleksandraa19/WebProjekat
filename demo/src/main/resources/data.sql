INSERT INTO KORISNIK(ime, prezime, korisnicko_ime, mejl_adresa, lozinka, datum_rodjenja, opis, uloga) VALUES ('Milos', 'Milosevic', 'milosm','milos.milosevic@gmail.com', 'nekasifra', '14.4.2002.','','CITALAC');
INSERT INTO KORISNIK(ime, prezime, korisnicko_ime, mejl_adresa, lozinka, datum_rodjenja, opis, uloga) VALUES ('Jovan', 'Jovanovic', 'jovanovic','jovan.jovanovic@gmail.com', 'nekasifra2', '1.6.2002.','','ADMINISTRATOR');


INSERT INTO ZANR(naziv) VALUES ('fantazija');
INSERT INTO ZANR(naziv) VALUES ('istorijska fikcija');

INSERT INTO KNJIGA(naslov, ISBN, datum_objavljivanja, br_strana, opis, zanr_id, ocena) VALUES ('Hari Poter', '132437727', '1.1.1997.',345, 'opis', 1, 9.6);
INSERT INTO KNJIGA(naslov, ISBN, datum_objavljivanja, br_strana, opis, zanr_id, ocena) VALUES ('Na Drini cuprija', '239439389', '12.3.1945.',366, 'opis2', 2, 10);

--INSERT INTO AUTOR(aktivnost, knjiga_id) VALUES (0, 2);



