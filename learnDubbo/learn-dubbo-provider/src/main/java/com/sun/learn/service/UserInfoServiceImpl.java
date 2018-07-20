package com.sun.learn.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.sun.learn.IUserInfoService;

/**
 * 功能： api接口的实现类
 * 
 * @author 孙荆阁:
 * @Date 2018年7月19日 上午9:53:53
 */
@Service(interfaceClass = IUserInfoService.class)
@Component
public class UserInfoServiceImpl implements IUserInfoService {

	public Map<String, Object> getUserInfo() {
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("id", 123456);
		userMap.put("name", "sjg");
		return userMap;
	}

}
