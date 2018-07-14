 package com.sun.nettyLearning.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月14日 下午3:26:30
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@PostMapping
	@ResponseBody
	public String login(String loginName,String loginPwd){
		System.out.println(loginName+"-"+loginPwd);
		return "success";
	}
	
	@GetMapping("/index")
	public String index(){
		return "index";
	}
}
