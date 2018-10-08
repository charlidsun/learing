package com.sun.learn.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.sun.learn.IBehaviorService;
import com.sun.learn.config.RabbitConfig;


@Service(interfaceClass = IBehaviorService.class)
@Component
public class BehaviorServiceImpl implements IBehaviorService{

	private final RabbitTemplate rabbitTemplate;

	@Autowired
	public BehaviorServiceImpl(RabbitTemplate rabbitTemplate){
		this.rabbitTemplate = rabbitTemplate;
	}
	
	
	
	public void sendBehaviorMessage(String msg) {
        System.out.println(msg);
        this.rabbitTemplate.convertAndSend(RabbitConfig.BEHAVIOR_COLLECTION_NAME, msg);
	}
	
}
