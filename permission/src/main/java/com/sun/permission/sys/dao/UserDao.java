package com.sun.permission.sys.dao;

import com.sun.permission.base.dao.GenericDao;
import com.sun.permission.sys.entity.QueryUser;
import com.sun.permission.sys.entity.User;

public interface UserDao extends GenericDao<User, QueryUser>{

	User findByLogin(String login);
}
