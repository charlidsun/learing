package com.sun.shiroLearning.auth.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月2日 下午1:43:27
 */
public class SysRole implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
	private String description; // 角色描述,UI界面显示使用
	private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户
	
	private List<SysPermission> userPermission;
	
	
	public List<SysPermission> getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(List<SysPermission> userPermission) {
		this.userPermission = userPermission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", role=" + role + ", description="
				+ description + ", available=" + available + "]";
	}

}
