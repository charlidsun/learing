package com.sun.learn.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sun.learn.IBehaviorService;

@RestController
@RequestMapping("/behavior")
public class BehaviorController {

	@Reference
	IBehaviorService behaviorService;
	
	@PostMapping("/msg")
	public void behaviorCollection(String msg) {
		System.out.println(msg);
		behaviorService.sendBehaviorMessage(msg);
	}
}
