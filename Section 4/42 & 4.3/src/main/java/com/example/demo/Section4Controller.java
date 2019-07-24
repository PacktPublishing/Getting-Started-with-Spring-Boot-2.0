package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entities.*;
@Controller
public class Section4Controller {

	PersonRepository repo;
	@Autowired
	PersonServiceImpl personservice;
	
	Section4Controller(PersonRepository rep)
	{
		this.repo=rep;
	}
	
	@RequestMapping("/")
	public String index(Model model)
	{
		List<Person> personlist = new ArrayList();
		
		personlist = repo.findAll();
		model.addAttribute("personlist", personlist);
		return "index";
	}
	
	@GetMapping("/newperson")
	public String newperson(Model model)
	{
		model.addAttribute("person", new Person());
		
		return "newperson";
	}
	
	@PostMapping("/newperson")
	public String newperson(@ModelAttribute("person") Person person, Model model)
	{
		personservice.addPerson(person);
		return "redirect:/";
	}
}
