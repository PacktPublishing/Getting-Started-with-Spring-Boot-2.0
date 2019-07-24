package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MVCAppControllerTest {

	@Autowired
	MockMvc mvc;
	
	@Test
	public void doGetTest() throws Exception
	{
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML))
		.andExpect(status().isOk());
	}
	
	@Test
	public void doPostTest() throws Exception
	{
		UserGreeting newUser = new UserGreeting();
		newUser.setName("Petra");
		
		mvc.perform(MockMvcRequestBuilders.post("/",newUser)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.flashAttr("usergreeting", newUser))
				.andExpect(status().isOk())
				.andExpect(view().name("index"))
				.andExpect(model().attribute("user", newUser.getName()));
		
	}
	
	
	
	
}
