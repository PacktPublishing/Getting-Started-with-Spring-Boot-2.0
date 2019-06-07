package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@Autowired
	private ApplicationProperties properties;
	
	@Value("${spring.application.name}")
	private String name;
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	

	@RequestMapping("/")
	public String index(final Model model)
	{
		model.addAttribute("name", getName());
		model.addAttribute("propertyname", properties.getApplicationname());
		return "index";
	}
	
	
	
}
