package com.sun.learnVue.home.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.learnVue.utils.DbUtils;

@Service
public class HomeService {

	@Autowired
	DbUtils dbUtils;
	
	public List<Map<String,Object>> getBannerList(){
		String sql = "select imgUrl from banner where status = 1";
		return dbUtils.getList(sql);
	}
	
}
