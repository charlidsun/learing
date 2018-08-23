package com.sun.learnVue.utils;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DbUtils {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> getList (String sql){
		return jdbcTemplate.queryForList(sql);
	}
	
	public Map<String,Object> getSingle (String sql){
		return jdbcTemplate.queryForMap(sql);
	}
}
