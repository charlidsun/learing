package com.sun.learn.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	public static final String BEHAVIOR_COLLECTION_NAME = "behavior_collection";
	
	@Bean
	public Queue getBheaviorQueue() {
		return new Queue(BEHAVIOR_COLLECTION_NAME, true);
	}
}
