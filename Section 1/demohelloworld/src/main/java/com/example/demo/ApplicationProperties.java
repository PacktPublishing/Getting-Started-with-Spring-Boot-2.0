package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application")
public class ApplicationProperties {

	private String applicationname;
	
	public void setApplicationname(String name)
	{
		this.applicationname=name;
	}
	
	public String getApplicationname()
	{
		return applicationname;
	}
}
