package com.sun.magic.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月26日 下午1:35:47
 */
@Repository
public class HeadDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int save(Map<String, Object> map) {
		String sql = mapToInsertSql(map, "myimg");
		System.out.println(sql);
		return jdbcTemplate.update(sql);
	}

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
				// 判断字符串中是否有'，如果有，转义
				if (((String) value).indexOf("'") > 0) {
					((String) value).replaceAll("'", "\'");
				}
				str += "'" + value + "',";
			}
		}
		str = str.substring(0, str.length() - 1);
		str += ")";
		return str;
	}
}
