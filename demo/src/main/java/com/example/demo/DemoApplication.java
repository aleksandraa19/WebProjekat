package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	/*
	@Autowired
	 repozitorijumi*/
	@Override
	public void run(String... args) throws Exception {
		//testiranje objekata iz data.sql
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}




