package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	private final AppService appservice;
	
	public MainController(AppService apps)
	{
		this.appservice=apps;
	}
	
	@RequestMapping("/")
	public String root()
	{
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/user/index")
	public String userindex(Model model)
	{
		model.addAttribute("welcomeMessage", appservice.getWelcomeMessage());
		return "user/index";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/login-error")
	public String loginError(Model model)
	{	model.addAttribute("loginError", true);
		return "login";
	}
}
