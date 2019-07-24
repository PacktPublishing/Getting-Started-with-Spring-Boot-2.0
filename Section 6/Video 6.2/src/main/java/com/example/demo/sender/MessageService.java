package com.example.demo.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;


@Component
public class MessageService {
	
		private AmqpTemplate amqptemplate;
		
		public MessageService(AmqpTemplate amp)
		{
			this.amqptemplate=amp;
		}
		
		public void sendMessage(String message)
		{
			this.amqptemplate.convertAndSend(message);
		}
}
