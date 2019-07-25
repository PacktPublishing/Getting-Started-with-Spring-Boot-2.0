package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"eng"})
public class EnglishMessageService implements WelcomeMessageService {

	private final ApplicationProperties props;
	
	public EnglishMessageService(ApplicationProperties props)
	{
		this.props = props;
	}
	@Override
	public String getWelcomeMessage() {
		return this.props.getWelcome() + " " + this.props.getGreeting();
	}

}
