package com.sun.magic.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.magic.domain.Movies;
import com.sun.magic.repository.MoviesDao;

/**
 * 功能： 说明：保存用户名和头像
 * 
 * @author 孙荆阁:
 * @Date 2018年7月26日 下午1:33:14
 */
@Service
public class MoviesService {

	@Autowired
	MoviesDao moviesDao;

	public int save(Movies movies) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", movies.getId());
		param.put("actor", movies.getActor());
		param.put("imgUrl", movies.getImgUrl());
		param.put("intr", movies.getIntr());
		param.put("linkList", movies.getLinkList());
		param.put("peoRate", movies.getPeoRate());
		param.put("rate", movies.getRate());
		param.put("title", movies.getTitle());
		return moviesDao.save(param);
	}
}
