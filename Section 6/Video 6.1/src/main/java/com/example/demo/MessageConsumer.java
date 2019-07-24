package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.example.demo.config.MessageConfig;
import com.example.demo.receiver.MessageReceiver;


public class MessageConsumer {

	
	
	public static void main(String[] args)
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				MessageConfig.class);

		MessageReceiver messageReceiver = (MessageReceiver) context.getBean("messageReceiver");
		String response = messageReceiver.receiveMessage();
		System.out.println("Message Received = " + response);

		((AbstractApplicationContext) context).close();
}
}
