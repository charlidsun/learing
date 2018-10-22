package com.sun.permission.common.config.security;

import javax.inject.Inject;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sun.permission.sys.dao.UserDao;
import com.sun.permission.sys.entity.User;

/**
 *  登录逻辑
 * @author Administrator
 *
 */
public class CustomUserService implements UserDetailsService{

	@Inject
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 System.out.println(username);
		 User user = userDao.findByLogin(username);
	        if(user == null){
	            throw new UsernameNotFoundException("用户名不存在");
	        }
	        System.out.println(user);
	        // 自定义错误的文章说明的地址：http://blog.csdn.net/z69183787/article/details/21190639?locationNum=1&fps=1
	        if(user.getState().equalsIgnoreCase("0")){
	            throw new LockedException("用户账号被冻结，无法登陆请联系管理员！");
	        }
	        return user;

	}

}
