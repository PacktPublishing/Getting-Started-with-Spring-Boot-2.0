package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
