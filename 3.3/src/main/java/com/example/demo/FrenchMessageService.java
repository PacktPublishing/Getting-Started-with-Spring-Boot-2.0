package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"french"})
public class FrenchMessageService implements WelcomeMessageService {

	private final ApplicationProperties props;
	
	public FrenchMessageService(ApplicationProperties p)
	{
		this.props = p;
	}
	
	@Override
	public String getWelcomeMessage() {
		// TODO Auto-generated method stub
		String welcome = this.props.getWelcome();
		welcome+=", Bienvenu a France!";
		welcome += this.props.getGreeting();
		return welcome;
	}

}
