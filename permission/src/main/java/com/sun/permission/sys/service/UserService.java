package com.sun.permission.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.permission.base.dao.GenericDao;
import com.sun.permission.base.service.GenericService;
import com.sun.permission.sys.dao.UserDao;
import com.sun.permission.sys.entity.QueryUser;
import com.sun.permission.sys.entity.User;


@Service("userService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class UserService extends GenericService<User, QueryUser> {

	@Autowired
	private UserDao userDao;

	@Override
	protected GenericDao<User, QueryUser> getDao() {
		return userDao;
	}
	
	

}