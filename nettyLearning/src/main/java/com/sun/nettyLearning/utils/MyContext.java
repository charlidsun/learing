package com.sun.nettyLearning.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.support.WebApplicationContextUtils;

public class MyContext {

	// 封装一下，类的class和请求request为必要参数
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<? extends Object> cla, HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		return (T) WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext())
				.getBean(cla);// getBean参数可为bean类的.class或直接是bean的Id
	}

}
