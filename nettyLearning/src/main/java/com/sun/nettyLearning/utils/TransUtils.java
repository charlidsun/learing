package com.sun.nettyLearning.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年6月30日 上午11:43:48
 */
public class TransUtils {

	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass)
			throws Exception {
		if (map == null)
			return null;
		Object obj = beanClass.newInstance();
		org.apache.commons.beanutils.BeanUtils.populate(obj, map);
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> listMapToList(List<Map<String, Object>> mapList, Class<?> beanClass) throws Exception{
		if (mapList == null){
			return null;
		}
		List<Object> list = new ArrayList<>();
		for (Map<String,Object> map : mapList){
			Object o = mapToObject(map, beanClass);
			list.add(o);
		}
		return (List<T>) list;
	}
	
	public static String mapValueToStr(Map<String,Object> map,String key) {
		String userId = "";
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (!entry.getKey().equals(key)) {
				userId += "'" +entry.getKey() +"',";
			}
		}
		if (userId.equals("")) {
			return "";
		}else {
			return userId.substring(0,userId.length()-1);
		}
	}
	
	
	public static String getKeyByValue(Map<String,Object> map,String value) {
		String resultKey = "";
		for(Map.Entry<String,Object> str : map.entrySet()){
		    if(str.equals(str.getValue())){
		         resultKey = str.getKey();
		   }
		}
		return resultKey;
	}

	

	
}
