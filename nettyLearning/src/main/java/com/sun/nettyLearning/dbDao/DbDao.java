package com.sun.nettyLearning.dbDao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月14日 下午5:27:59
 */
@Repository
public class DbDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Map<String,Object> queryMap(String sql){
		return jdbcTemplate.queryForMap(sql);
	}
	
	public List<Map<String,Object>> queryListMap(String sql){
		return jdbcTemplate.queryForList(sql);
	}
}
