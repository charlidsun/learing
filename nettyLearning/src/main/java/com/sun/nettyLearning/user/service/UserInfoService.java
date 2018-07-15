package com.sun.nettyLearning.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.nettyLearning.dbDao.DbDao;
import com.sun.nettyLearning.user.entity.UserInfo;
import com.sun.nettyLearning.utils.TransUtils;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月14日 下午5:31:33
 */
@Service
public class UserInfoService {

	@Autowired
	DbDao dbDao;
	
	public UserInfo getUserInfo(String name) {
		String sql = "select login.id,login.loginName,loginPwd,login.salt,login.lock,detail.userName,detail.phone,detail.gender,detail.headImg,detail.selfIntr from userlogin login LEFT JOIN userdetails detail on login.id = detail.id where login.loginName='"+name+"'";
		Map<String,Object> userMap = dbDao.queryMap(sql);
		UserInfo userInfo = null;
		try {
			userInfo = (UserInfo) TransUtils.mapToObject(userMap, UserInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println(userInfo.getLoginName());
		return userInfo;
	}
	public List<UserInfo> getListUserInfo(String name) {
		if (name.equals("")) {
			return null;
		}
		String sql = "select login.id,login.loginName,loginPwd,login.salt,login.lock,detail.userName,detail.phone,detail.gender,detail.headImg,detail.selfIntr from userlogin login LEFT JOIN userdetails detail on login.id = detail.id where login.loginName in ("+name+")";
		List<Map<String,Object>> userMap = dbDao.queryListMap(sql);
		List<UserInfo> userInfo = null;
		try {
			userInfo = TransUtils.listMapToList(userMap, UserInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}
}
