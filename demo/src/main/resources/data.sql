INSERT INTO KORISNIK(ime, prezime, korisnickoIme, mejlAdresa, lozinka, datumRodjenja, opis, uloga) VALUES ('Milos', 'Milosevic', 'milosm','milos.milosevic@gmail.com', 'nekasifra', '14.4.2002.','','CITALAC');
INSERT INTO KORISNIK(ime, prezime, korisnickoIme, mejlAdresa, lozinka, datumRodjenja, opis, uloga) VALUES ('Jovan', 'Jovanovic', 'jovanovic','jovan.jovanovic@gmail.com', 'nekasifra2', '1.6.2002.','','ADMINISTRATOR');


INSERT INTO ZANR(naziv) VALUES ('komedija');
INSERT INTO ZANR(naziv) VALUES ('drama');

INSERT INTO KNJIGA(naslov, ISBN, datumObjavljivanja, brStrana, opis, zanr, ocena) VALUES ('Hari Poter', '132437727', '1.1.1997.',345, 'opis', 'fantazija', 9,6);
INSERT INTO KNJIGA(naslov, ISBN, datumObjavljivanja, brStrana, opis, zanr, ocena) VALUES ('Na Drini cuprija', '239439389', '12.3.1945.',366, 'opis2', 'istorijska fikcija', 10);

INSERT INTO AUTOR(aktivnost, knjiga_id) VALUES (0, 2);



