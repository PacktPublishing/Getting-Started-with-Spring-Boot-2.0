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
	
		Contact c1=new Contact("21, Jump Street", "Los Angeles");
		
		Contact c2=new Contact("22, Jump Street", "Los Angeles");
		Contact c3=new Contact("23, Jump Street", "Los Angeles");
		Contact c4=new Contact("24, Jump Street", "Los Angeles");
		
		Contact c5=new Contact("25, Jump Street", "Los Angeles");
		
		Person p1 = new Person("Petra", "Simonis", c1);
		
		
		Person p2 =new Person("Claire", "Muller",c2);
		Person p3 =new Person("Fantasia", "Bauer",c3);
		Person p4 =new Person("David", "Becker",c4);
		Person p5 =new Person("Michelle", "Geller",c5);
		repo.save(p1);
		
		repo.save(p2);
		
		repo.save(p3);
		
		repo.save(p4);
		
		repo.save(p5);
		
	};
	}
}
