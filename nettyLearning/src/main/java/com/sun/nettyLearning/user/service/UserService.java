package com.sun.nettyLearning.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.nettyLearning.dbDao.DbDao;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月14日 下午5:31:33
 */
@Service
public class UserService {

	@Autowired
	DbDao dbDao;
	
	
}
