package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entities.*;
@Controller
public class Section4Controller {

	PersonRepository repo;
	
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
}
