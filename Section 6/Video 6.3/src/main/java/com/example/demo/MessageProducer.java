package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.demo.config.MessageConfig;
import com.example.demo.sender.MessagePublisher;


public class MessageProducer {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				MessageConfig.class);

		MessagePublisher messageSender = (MessagePublisher) context.getBean("redisPublisher");
		messageSender.publish("Hello world, how are you?");
		System.out.println("Message has been sent successfully...");

((AbstractApplicationContext) context).close();

	}

}
