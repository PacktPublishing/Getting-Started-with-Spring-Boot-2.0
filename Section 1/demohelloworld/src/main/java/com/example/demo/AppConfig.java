package com.example.demo;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	private ApplicationProperties applicationproperties;
	
	public AppConfig(ApplicationProperties properties)
	{
		this.applicationproperties = properties;
	}
}
