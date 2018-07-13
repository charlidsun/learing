package com.sun.nettyLearning.trans;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月13日 下午4:35:44
 */
public class JsonUtils {

	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonString
	 * @param beanCalss
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToBean(String jsonString, Class<T> beanCalss) {

		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		T bean = (T) JSONObject.toBean(jsonObject, beanCalss);

		return bean;

	}

	/**
	 * 将java对象转换成json字符串
	 *
	 * @param bean
	 * @return
	 */
	public static String beanToJson(Object bean) {

		JSONObject json = JSONObject.fromObject(bean);

		return json.toString();

	}

}
