package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.antMatchers("/index").permitAll()
		.antMatchers("/user/**").hasRole("USER")
		.and()
		.formLogin().loginPage("/login").failureUrl("/login-error");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser(User.withDefaultPasswordEncoder().username("user")
				.password("password")
				.roles("USER"));
	}
}
