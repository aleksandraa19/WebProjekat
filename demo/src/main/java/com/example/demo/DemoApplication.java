package com.example.demo;

import com.example.demo.entity.Autor;
import com.example.demo.entity.Knjiga;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.KnjigaRepository;
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

	@Override
	public void run(String... args) throws Exception {
		//testiranje objekata iz data.sql
		Knjiga k1 = this.knjigaRepository.findById(1);
		System.out.println(k1);

		//autor
		List<Autor> lista_autora = this.autorRepository.findAll();
		for(Autor a: lista_autora){
			System.out.println(a);
		}

	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}




