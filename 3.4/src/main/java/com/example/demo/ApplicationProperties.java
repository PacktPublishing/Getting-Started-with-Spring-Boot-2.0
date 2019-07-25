package com.example.demo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application")
public class ApplicationProperties {

	private String applicationname;
	private String greeting;
	private String welcome;
	
	public void setApplicationname(String name)
	{
		this.applicationname=name;
	}
	
	public String getApplicationname()
	{
		return applicationname;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
}
