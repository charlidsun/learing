package com.sun.magic.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.magic.domain.MyHead;
import com.sun.magic.repository.HeadDao;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月26日 下午1:33:14
 */
@Service
public class HeadService {

	@Autowired
	HeadDao headDao;

	public int save(MyHead head) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("img", head.getImg());
		return headDao.save(param);
	}
}
