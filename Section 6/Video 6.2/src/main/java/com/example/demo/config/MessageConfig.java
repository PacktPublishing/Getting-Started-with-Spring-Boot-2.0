package com.example.demo.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class MessageConfig {
	private static final String DEFAULT_BROKER_URL = "localhost";
	private static final String MESSAGE_QUEUE = "message_queue";
	
	@Bean
	public ConnectionFactory connectionFactory()
	{
		return new CachingConnectionFactory(DEFAULT_BROKER_URL);
	}

	
	@Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
    	RabbitTemplate template = new RabbitTemplate(connectionFactory());
    	template.setRoutingKey(MESSAGE_QUEUE);
    	template.setDefaultReceiveQueue(MESSAGE_QUEUE);
    	return template;
    }

    @Bean
    public Queue myQueue() {
       return new Queue(MESSAGE_QUEUE);
    }
	
    @Bean
    public MessageConverter messageConverter()
    {
    	return new SimpleMessageConverter();
    }
}
