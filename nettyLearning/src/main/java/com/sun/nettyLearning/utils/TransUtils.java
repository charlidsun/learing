package com.sun.nettyLearning.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 功能： 常用的转化类
 * 
 * @author sjg:
 * @Date 2018年6月30日 上午11:43:48
 */
public class TransUtils {

	/**
	 * 
	 * 功能： 将map转换为bean
	 * @Description: 注意map里面的值必须与实体相同
	 * @param: @param map
	 * @param: @param beanClass
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: Object 
	 * @author : sjg
	 * @Date 2018年7月17日 上午10:09:38  
	 * 修改日期 修改人 修改内容
	 * <多次修改需另起一行>
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null)
			return null;
		Object obj = beanClass.newInstance();
		org.apache.commons.beanutils.BeanUtils.populate(obj, map);
		return obj;
	}

	/**
	 * 
	 * 功能： 将List<map>转换为List<bean>
	 * @Description: 注意map里面的值必须与实体相同
	 * @param: @param mapList
	 * @param: @param beanClass
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<T> 
	 * @author : sjg
	 * @Date 2018年7月17日 上午10:10:19  
	 * 修改日期 修改人 修改内容
	 * <多次修改需另起一行>
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> listMapToList(List<Map<String, Object>> mapList, Class<?> beanClass) throws Exception {
		if (mapList == null) {
			return null;
		}
		List<Object> list = new ArrayList<>();
		for (Map<String, Object> map : mapList) {
			Object o = mapToObject(map, beanClass);
			list.add(o);
		}
		return (List<T>) list;
	}

	/**
	 * 
	 * 功能： 输出map的key值，除去key值。以sql in 的方式返回
	 * @Description: '2','3'   
	 * @param: @param map
	 * @param: @param key
	 * @param: @return      
	 * @return: String 
	 * @author : sjg
	 * @Date 2018年7月17日 上午10:11:34  
	 * 修改日期 修改人 修改内容
	 * <多次修改需另起一行>
	 */
	public static String mapKeyToStr(Map<String, Object> map, String key) {
		String userId = "";
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (!entry.getKey().equals(key)) {
				userId += "'" + entry.getKey() + "',";
			}
		}
		if (userId.equals("")) {
			return "";
		} else {
			return userId.substring(0, userId.length() - 1);
		}
	}

	/**
	 * 
	 * 功能： 根据value值获取key值
	 * @Description: value值和key值必须是唯一的   
	 * @param: @param map
	 * @param: @param value
	 * @param: @return      
	 * @return: String 
	 * @author : sjg
	 * @Date 2018年7月17日 上午10:12:31  
	 * 修改日期 修改人 修改内容
	 * <多次修改需另起一行>
	 */
	public static String getKeyByValue(Map<String, Object> map, String value) {
		String resultKey = "";
		for (Map.Entry<String, Object> str : map.entrySet()) {
			if (value.equals(str.getValue())) {
				resultKey = str.getKey();
			}
		}
		return resultKey;
	}

	/**
	 * 
	 * 功能： 将map的key和value转换为update的sql
	 * @Description: map中必须要有id
	 * @param: @param map
	 * @param: @param tb
	 * @param: @return      
	 * @return: String 
	 * @author : sjg
	 * @Date 2018年7月17日 上午10:13:31  
	 * 修改日期 修改人 修改内容
	 * <多次修改需另起一行>
	 */
	public static String mapToUpdateSql(Map<String, Object> map, String tb) {
		String str = "update " + tb + " set ";
		for (String key : map.keySet()) {
			if (!key.equals("id")) {
				str += key + "=";
				String val = map.get(key).toString();
				str += "'" + val + "',";
			}
		}
		str = str.substring(0, str.length() - 1);
		str += " where id=" + map.get("id");
		return str;
	}

	/**
	 * 
	 * 功能： 将map的key和value转换为insert的sql
	 * @Description:  ID采用数据库自增，会自动清除。 
	 * @param: @param map
	 * @param: @param tb
	 * @param: @return      
	 * @return: String 
	 * @author : sjg
	 * @Date 2018年7月17日 上午10:16:01  
	 * 修改日期 修改人 修改内容
	 * <多次修改需另起一行>
	 */
	public static String mapToInsertSql(Map<String, Object> map, String tb) {
		map.remove("id");
		String str = "insert into " + tb + " (";
		for (String key : map.keySet()) {
			str += key + ",";
		}
		str = str.substring(0, str.length() - 1);
		str += ") VALUES (";
		for (Object value : map.values()) {
			if (value instanceof Integer) {
				str += value + ",";
			}
			if (value instanceof String) {
				str += "'" + value + "',";
			}
		}
		str = str.substring(0, str.length() - 1);
		str += ")";
		return str;
	}

	/**
	 * 
	 * 功能： 获取当前的时间
	 * @Description: 格式：年月日 时分秒
	 * @param: @return      
	 * @return: String 
	 * @author : sjg
	 * @Date 2018年7月17日 上午10:15:11  
	 * 修改日期 修改人 修改内容
	 * <多次修改需另起一行>
	 */
	public static String getToday() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(d);
		return dateNowStr;
	}
}
