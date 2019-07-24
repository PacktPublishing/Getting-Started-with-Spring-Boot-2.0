package com.example.demo.receiver;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	MessageConverter messageConverter;

	public String receiveMessage()
	{
		try
		{
			Message message = jmsTemplate.receive();
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
