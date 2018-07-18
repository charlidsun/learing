 package com.sun.nettyLearning.user.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月14日 下午3:26:30
 */
@Controller
public class LoginController {
	
	private static Logger log = LogManager.getLogger("LoginValitController.class");
		
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(HttpServletResponse response,String loginName,String loginPwd,Model model) throws Exception{
		Subject sub = SecurityUtils.getSubject();
		System.out.println(loginName+"-"+loginPwd);
		UsernamePasswordToken token = new UsernamePasswordToken(loginName,
				loginPwd);
		try {
			sub.login(token);
		} catch (UnknownAccountException e) {
			log.error("对用户[{}]进行登录验证,验证未通过,用户不存在", loginName);
			token.clear();
			model.addAttribute("msg", "用户不存在");
			return "login";
			//throw new CustomException(2001, "UnknownAccountException");
		} catch (LockedAccountException lae) {
			log.error("对用户[{}]进行登录验证,验证未通过,账户已锁定", loginName);
			token.clear();
			model.addAttribute("msg", "账户已锁定");
			return "login";
			//throw new CustomException(2002, "LockedAccountException");
		} catch (ExcessiveAttemptsException e) {
			log.error("对用户[{}]进行登录验证,验证未通过,错误次数过多", loginName);
			token.clear();
			model.addAttribute("msg", "错误次数过多");
			return "login";
			//throw new CustomException(2003, "ExcessiveAttemptsException");
		} catch (AuthenticationException e) {
			log.error("对用户[{}]进行登录验证,验证未通过,堆栈轨迹如下", loginName, e);
			token.clear();
			model.addAttribute("msg", "验证未通过");
			return "login";
			//throw new CustomException(2004, "AuthenticationException");
		}
		//response.sendRedirect("index");
		model.addAttribute("userId", loginName);
		return "chat/chat";
	}
	
	@GetMapping(value="/index")
	public String index(){
		return "chat/chat";
	}
}
