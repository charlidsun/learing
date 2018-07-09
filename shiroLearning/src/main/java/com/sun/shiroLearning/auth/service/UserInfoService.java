package com.sun.shiroLearning.auth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.shiroLearning.auth.dao.UserInfoDao;
import com.sun.shiroLearning.auth.entity.SysPermission;
import com.sun.shiroLearning.auth.entity.SysRole;
import com.sun.shiroLearning.auth.entity.UserInfo;
import com.sun.shiroLearning.uitls.TransUtils;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月9日 上午9:13:38
 */
@Service
public class UserInfoService {

	@Autowired
	UserInfoDao userInfoDao;
	
	public UserInfo queryUserInfoByName(String name){
		UserInfo userInfo = new UserInfo();
		Map<String,Object> userMap = userInfoDao.querySql("select * from userinfo where username='"+name+"'");
		try {
			userInfo = (UserInfo)TransUtils.mapToObject(userMap, com.sun.shiroLearning.auth.entity.UserInfo.class);
			if (userInfo != null){
				List<Map<String,Object>> userRole = userInfoDao.queryList(("SELECT ro.id,ro.description,ro.role FROM sysrole ro LEFT JOIN sysuserrole ro_re ON ro_re.roleId = ro.id LEFT JOIN userinfo info ON info.uid = ro_re.uid where ro_re.uid=")+userInfo.getUid());
				List<SysRole> roleList = TransUtils.listMapToList(userRole, com.sun.shiroLearning.auth.entity.SysRole.class); 
				userInfo.setUserRole(roleList);
				for (SysRole s:roleList){
					List<Map<String,Object>> userPermission = userInfoDao.queryList(("SELECT * FROM syspermission pe LEFT JOIN sysrolepermission pe_re ON pe_re.permissionId = pe.id WHERE pe_re.roleId=")+s.getId());
					List<SysPermission> permList = TransUtils.listMapToList(userPermission, com.sun.shiroLearning.auth.entity.SysPermission.class);
					s.setUserPermission(permList);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
	public List<SysRole> querySysRole(String name) {
		List<Map<String, Object>> userRole = userInfoDao.queryList("SELECT * from SysRole");
		List<SysRole> roleList = null;
		try {
			roleList = TransUtils.listMapToList(userRole, com.sun.shiroLearning.auth.entity.SysRole.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleList;
	}

	public int saveOrUpdateRole(Map<String, Object> map) {
		String sql = "";
		if ("".equals(map.get("id"))){
			sql = TransUtils.mapToInsertSql(map, "SysRole");
		}else{
			sql = TransUtils.mapToUpdateSql(map, "SysRole");
		}
		System.err.println(sql);
		return userInfoDao.saveSql(sql);
	}

	
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		map.put("role", "ddd");
		map.put("description", "3333");
		map.put("available", 1);
		map.put("id", 222);
		//System.out.println(transUp(map, "sysrole"));
	}
	
	
}
