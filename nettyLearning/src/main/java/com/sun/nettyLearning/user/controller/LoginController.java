 package com.sun.nettyLearning.user.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sun.nettyLearning.user.entity.UserInfo;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月14日 下午3:26:30
 */
@Controller
public class LoginController {
	
	private static Logger log = LogManager.getLogger("LoginController.class");
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

	@PostMapping(value = "/login")
	public String login(String loginName,String loginPwd,Model model){
		Subject sub = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(loginName,
				loginPwd);
		try {
			sub.login(token);
		} catch (UnknownAccountException e) {
			log.error("对用户[{}]进行登录验证,验证未通过,用户不存在", loginName);
			token.clear();
			return "UnknownAccountException";
		} catch (LockedAccountException lae) {
			log.error("对用户[{}]进行登录验证,验证未通过,账户已锁定", loginName);
			token.clear();
			return "LockedAccountException";
		} catch (ExcessiveAttemptsException e) {
			log.error("对用户[{}]进行登录验证,验证未通过,错误次数过多", loginName);
			token.clear();
			return "ExcessiveAttemptsException";
		} catch (AuthenticationException e) {
			log.error("对用户[{}]进行登录验证,验证未通过,堆栈轨迹如下", loginName, e);
			token.clear();
			return "AuthenticationException";
		}
		model.addAttribute("userId",loginName);
		return "chat/chat";
	}
	
	@GetMapping("/index")
	public String index(){
		return "success";
	}
}
