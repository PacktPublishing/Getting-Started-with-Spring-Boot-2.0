package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import org.springframework.data.redis.serializer.GenericToStringSerializer;

import com.example.demo.receiver.RedisMessageSubscriber;
import com.example.demo.sender.MessagePublisher;
import com.example.demo.sender.RedisMessagePublisher;

@Configuration
public class MessageConfig {
	
	private static final String MESSAGE_QUEUE = "pubsub:message_queue";
	
	JedisConnectionFactory jedisConnectionFactory() {
	    JedisConnectionFactory jedisConFactory
	      = new JedisConnectionFactory();
	    
	    return jedisConFactory;
	}

	
	 @Bean
	    public RedisTemplate<String, Object> redisTemplate() {
	        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	        template.setConnectionFactory(jedisConnectionFactory());
	        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
	        return template;
	}


	    @Bean
	    MessageListenerAdapter messageListener() {
	        return new MessageListenerAdapter(new RedisMessageSubscriber());
	    }

	    @Bean
	    RedisMessageListenerContainer redisContainer() {
	        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
	        container.setConnectionFactory(jedisConnectionFactory());
	        container.addMessageListener(messageListener(), topic());
	        return container;
	    }

	    @Bean
	    MessagePublisher redisPublisher() {
	        return new RedisMessagePublisher(redisTemplate(), topic());
	    }

	    @Bean
	    ChannelTopic topic() {
	        return new ChannelTopic(MESSAGE_QUEUE);
	}
}
