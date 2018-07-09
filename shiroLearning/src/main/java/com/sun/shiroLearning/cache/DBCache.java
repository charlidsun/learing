package com.sun.shiroLearning.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sun.shiroLearning.auth.entity.UserInfo;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月6日 上午10:35:11
 */
public class DBCache {

	public static Map<String,UserInfo> USER_CACHE = new HashMap<String,UserInfo>();
	public static Map<String,Collection<String>> PERMISSON_CACHE = new HashMap<String, Collection<String>>();
	
	//static{}(即static块)，会在类被加载的时候执行且仅会被执行一次，一般用来初始化静态变量和调用静态方法
	static {
		//USER_CACHE.put("gj", new UserInfo(1L, "gj", "123456", "admin", false));
		//USER_CACHE.put("hr", new UserInfo(1L, "hr", "123456", "manager", false));
		//USER_CACHE.put("yg", new UserInfo(1L, "yg", "123456", "noraml", false));
		
		//Arrays.asList()把数组转换成集合,转换后的集合无add/remove/clear方法
		//PERMISSON_CACHE.put("admin", Arrays.asList("userInfo:list","userInfo:add","userInfo:edit"));
		//PERMISSON_CACHE.put("manager", Arrays.asList("userInfo:list","userInfo:add"));
		//Collections.singletonList——用来生成只读 的单一元素的List 
		//PERMISSON_CACHE.put("manager", Arrays.asList("userInfo:list"));
	}
}
