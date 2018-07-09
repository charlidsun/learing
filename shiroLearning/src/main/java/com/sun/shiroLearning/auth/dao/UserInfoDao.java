package com.sun.shiroLearning.auth.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月9日 上午9:18:04
 */
@Repository
public class UserInfoDao {

	@Autowired
	JdbcTemplate jdbc;

	public List<Map<String, Object>> queryList(String sql) {
		return jdbc.queryForList(sql);
	}

	public Map<String, Object> querySql(String sql) {
		return jdbc.queryForMap(sql);
	}

	public int saveSql(String sql) {
		return jdbc.update(sql);
	}

}
