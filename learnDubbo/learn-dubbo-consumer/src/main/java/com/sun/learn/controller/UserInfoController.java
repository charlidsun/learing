package com.sun.learn.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sun.learn.IUserInfoService;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月19日 上午10:05:01
 */
@RestController
@RequestMapping("/hello")
public class UserInfoController {

	@Reference
	IUserInfoService userService;
	
	@GetMapping
	public Map<String,Object> getUserInfo(){
		return userService.getUserInfo();
	}
}
