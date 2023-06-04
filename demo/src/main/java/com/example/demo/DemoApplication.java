package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	/*
	@Autowired
	 repozitorijumi*/
	@Autowired
	private KnjigaRepository knjigaRepository;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private KorisnikRepository korisnikRepository;

	@Autowired
	private ZahtevRepository zahtevRepository;

	@Autowired
	private PolicaRepository policaRepository;

	@Autowired
	private RecenzijaRepository recenzijaRepository;

	@Autowired
	private StavkaPoliceRepository stavkaPoliceRepository;

	@Override
	public void run(String... args) throws Exception {
		//testiranje objekata iz data.sql
		System.out.println("Testiranje klase Knjiga:");
		Knjiga k1 = this.knjigaRepository.findById(1);
		System.out.println(k1);

		//autor
		System.out.println();
		System.out.println("Testiranje klase Autor:");
		List<Autor> lista_autora = this.autorRepository.findAll();
		for(Autor a: lista_autora){
			System.out.println(a);
		}
		//korisnik
		System.out.println();
		System.out.println("Testiranje klase Korisnik:");
		List<Korisnik> lista_korisnika = this.korisnikRepository.findAll();
		for(Korisnik k: lista_korisnika){
			System.out.println(k);
		}

		//zahtev
		System.out.println();
		System.out.println("Testiranje klase Zahtev:");
		Zahtev z1 = this.zahtevRepository.findById(1);
		System.out.println(z1);

		//polica
		System.out.println();
		System.out.println("Testiranje klase Polica:");
		List<Polica> lista_polica = this.policaRepository.findAll();
//		Polica p1 = new Polica("polica3",true);
//		Polica p2 = new Polica("polica4",false);
//		lista_polica.add(p1);
//		lista_polica.add(p2);
		for(Polica p: lista_polica){
			System.out.println(p);
		}

		//recenzija
		System.out.println();
		System.out.println("Testiranje klase Recenzija:");
		//Recenzija r1 = this.recenzijaRepository.findRecenzijaByDatumRecenzije("16.4.2023.");
		//Recenzija r1 = new Recenzija(10, "text1", "2023-16-04", lista_korisnika.get(1));
		//this.recenzijaRepository.save(r1);
	//	System.out.println(r1);

		//stavka police
		System.out.println();
		System.out.println("Testiranje klase StavkaPolice:");
		List<StavkaPolice> lista_stavkiPolica = this.stavkaPoliceRepository.findAll();
		for(StavkaPolice sp: lista_stavkiPolica){
			System.out.println(sp);
		}

	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}




