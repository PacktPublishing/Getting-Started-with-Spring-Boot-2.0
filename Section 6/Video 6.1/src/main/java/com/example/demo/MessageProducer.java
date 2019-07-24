package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.demo.config.MessageConfig;
import com.example.demo.sender.MessageService;

public class MessageProducer {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				MessageConfig.class);

		MessageService messageSender = context.getBean(MessageService.class);

		messageSender.sendMessage("Hello world, how are you?");
		System.out.println("Message has been sent successfully...");

((AbstractApplicationContext) context).close();

	}

}
