package com.sun.storage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sun.storage.dao.UserMapper;
import com.sun.storage.domain.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<User> getUsers() {
		return userMapper.getUsers();
	}

	public int addUser(User user) {
		return userMapper.addUser(user);
	}

	@Cacheable(value = "user", key = "#name")
	public List<User> getUsersByName(String name) {
		List<User> users = userMapper.getUsersByName(name);
		System.out.println("从数据库读取，而非读取缓存！");
		return users;
	}

}
