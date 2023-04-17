INSERT INTO KORISNIK(ime, prezime, korisnicko_ime, mejl_adresa, lozinka, datum_rodjenja, opis, uloga) VALUES ('Milos', 'Milosevic', 'milosm','milos.milosevic@gmail.com', 'nekasifra', '14.4.2002.','','CITALAC');
INSERT INTO KORISNIK(ime, prezime, korisnicko_ime, mejl_adresa, lozinka, datum_rodjenja, opis, uloga) VALUES ('Jovan', 'Jovanovic', 'jovanovic','jovan.jovanovic@gmail.com', 'nekasifra2', '1.6.2002.','','AUTOR');
INSERT INTO KORISNIK(ime, prezime, korisnicko_ime, mejl_adresa, lozinka, datum_rodjenja, opis, uloga) VALUES ('Maja', 'Markovic', 'majamm','maja.markovic@gmail.com', 'nekasifra3', '10.8.2002.','','ADMINISTRATOR');


INSERT INTO ZANR(naziv) VALUES ('fantazija');
INSERT INTO ZANR(naziv) VALUES ('istorijska fikcija');

INSERT INTO AUTOR(aktivnost, id) VALUES (0, 2);

INSERT INTO KNJIGA(naslov, ISBN, datum_objavljivanja, br_strana, opis, zanr_id, ocena, autor_id) VALUES ('Hari Poter', '132437727', '1.1.1997.',345, 'opis', 1, 9.6, 2);
INSERT INTO KNJIGA(naslov, ISBN, datum_objavljivanja, br_strana, opis, zanr_id, ocena, autor_id) VALUES ('Na Drini cuprija', '239439389', '12.3.1945.',366, 'opis2', 2, 10, 2);

INSERT INTO POLICA(naziv, oznaka) VALUES ('polica1', 1);
INSERT INTO POLICA(naziv, oznaka) VALUES ('polica2', 0);

INSERT INTO STAVKA_POLICE(knjiga_id, polica_id) VALUES (1, 1);
INSERT INTO STAVKA_POLICE(knjiga_id, polica_id) VALUES (2, 2);

INSERT INTO ZAHTEV(email, telefon, poruka, datum, status) VALUES ('@gmail.com', '060000111222', '', '16.4.2023.', 'ODOBREN');

INSERT INTO RECENZIJA(ocena, text, datum_recenzije, korisnik_id, stavka_id) VALUES (10, 'text1', '16.4.2023.', 1, 2);




