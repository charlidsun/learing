package com.sun.shiroLearning.uitls;

import java.util.ArrayList;
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
	
	public static String mapToUpdateSql(Map<String, Object> map, String tb) {
		String str = "update " + tb + " set ";
		for(String key : map.keySet()){
			if (!key.equals("id")){
				str +=key+"=";
				String val = map.get(key).toString();
				str += "'"+val+"',";
			}
		}
		str = str.substring(0, str.length()-1);
		str += " where id="+map.get("id");
		return str;
	}
	
	public static String mapToInsertSql(Map<String, Object> map, String tb) {
		map.remove("id");
		String str = "insert into " + tb + " (";
		for(String key : map.keySet()){
			str +=key+",";
		}
		str = str.substring(0, str.length()-1);
		str += ") VALUES (";
		for(Object value : map.values()){
			if (value instanceof Integer){
				str += value+",";
			}
			if (value instanceof String){
				str += "'" + value +"',";
			}
		}
		str = str.substring(0, str.length()-1);
		str += ")";
		return str;
	}
}
