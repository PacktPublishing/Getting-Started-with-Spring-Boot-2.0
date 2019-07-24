package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MVCAppController {

	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("usergreeting", new UserGreeting());
		return "index";
	}
	
	@PostMapping("/")
	public String index(@ModelAttribute("usergreeting") UserGreeting newuser, Model model)
	{
		model.addAttribute("user", newuser.getName());
		return "index";
	}
}
