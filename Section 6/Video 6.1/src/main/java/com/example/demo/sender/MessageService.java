package com.example.demo.sender;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class MessageService {
	
		private JmsTemplate jmstemplate;
		
		public MessageService(JmsTemplate jms)
		{
			this.jmstemplate=jms;
		}
		
		public void sendMessage(String message)
		{
			this.jmstemplate.send( 
					session->session.createTextMessage(message));
		}
}
