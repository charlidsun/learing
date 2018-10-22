package com.sun.permission.sys.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.permission.base.controller.GenericController;
import com.sun.permission.base.service.GenericService;
import com.sun.permission.sys.entity.QueryUser;
import com.sun.permission.sys.entity.User;
import com.sun.permission.sys.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends GenericController<User, QueryUser> {

	@Inject
	private UserService userService;

	@Override
	protected GenericService<User, QueryUser> getService() {
		return userService;
	}
}
