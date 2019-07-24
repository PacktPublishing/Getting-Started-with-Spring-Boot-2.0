package com.example.demo;

import com.example.demo.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Section4Application {

	public static void main(String[] args) {
		SpringApplication.run(Section4Application.class, args);
	}

	@Bean
	public CommandLineRunner createDB(PersonRepository repo)
	{
		
	return (args) -> {
		// save a couple of customers
		repo.save(new Person("Petra", "Simonis"));
		repo.save(new Person("Claire", "Muller"));
		repo.save(new Person("Fantasia", "Bauer"));
		repo.save(new Person("David", "Becker"));
		repo.save(new Person("Michelle", "Geller"));
	};
	}
}
