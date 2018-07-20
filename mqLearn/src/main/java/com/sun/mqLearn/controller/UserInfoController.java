package com.sun.mqLearn.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.mqLearn.config.RabbitConfig;
import com.sun.mqLearn.entity.UserInfo;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月20日 上午10:36:13
 */
@RestController
@RequestMapping("/book")
public class UserInfoController {

	//初始化，使用构造函数
	private final RabbitTemplate rabbitTemplate;
	
	@Autowired
	public UserInfoController(RabbitTemplate rabbitTemplate){
		this.rabbitTemplate = rabbitTemplate;
	}
	
	//
	@GetMapping
	public void defaultMsg(){
		UserInfo u = new UserInfo();
		u.setId(1);
		u.setUserName("zsf");
		u.setUserPwd("123456");
		this.rabbitTemplate.convertAndSend(RabbitConfig.DETAULT_BOOK_QUEUE, u);
		this.rabbitTemplate.convertAndSend(RabbitConfig.MANUAL_BOOK_QUEUE, u);
	}
	 
	
	
}
