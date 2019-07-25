package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

	private final ApplicationProperties properties;
	@Autowired
	public AppService(ApplicationProperties props)
	{
		this.properties = props;
	}
	
	public String getWelcomeMessage()
	{
		return this.properties.getWelcome() + " " + this.properties.getGreeting();
	}
}
