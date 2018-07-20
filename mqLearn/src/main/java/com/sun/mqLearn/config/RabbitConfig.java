 package com.sun.mqLearn.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月20日 上午10:24:54
 */
@Configuration
public class RabbitConfig {

	public static final String DETAULT_BOOK_QUEUE = "dev.book.register.default.queue";
	public static final String MANUAL_BOOK_QUEUE = "dev.book.register.manual.queue";
	
	@Bean
	public Queue getDetaultQueue(){
		return new Queue(DETAULT_BOOK_QUEUE, true);
	}
	
	@Bean
	public Queue getManualQueue(){
		return new Queue(MANUAL_BOOK_QUEUE, true);
	}
}
