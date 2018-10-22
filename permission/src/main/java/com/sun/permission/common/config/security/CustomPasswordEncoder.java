package com.sun.permission.common.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *    密码加密类 md5加密
 *  Md5PasswordEncoder 
 * 
 * @author Administrator
 *
 */
public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return (String) rawPassword;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return (rawPassword.equals(encodedPassword));
	}
}
