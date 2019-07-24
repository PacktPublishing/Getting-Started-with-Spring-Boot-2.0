package com.example.demo.receiver;



import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
	@Autowired
	AmqpTemplate amqptemplate;
	@Autowired
	MessageConverter messageConverter;

	public String receiveMessage()
	{
		try
		{
			Message message = amqptemplate.receive();
			String response = (String) messageConverter.fromMessage(message);
			return response;

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
}
}
