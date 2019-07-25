package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	private final WelcomeMessageService appservice;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	public MainController(WelcomeMessageService apps)
	{
		this.appservice=apps;
	}
	
	@RequestMapping("/")
	public String root()
	{
		logger.debug("root path");
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String index()
	{
		logger.debug("index path");
				return "index";
	}
	
	@RequestMapping("/user/index")
	public String userindex(Model model)
	{
		logger.debug("user/index path");
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
