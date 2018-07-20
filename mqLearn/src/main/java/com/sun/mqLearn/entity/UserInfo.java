package com.sun.mqLearn.entity;

import java.io.Serializable;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月20日 上午10:31:59
 */
public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String userPwd;
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", userPwd="
				+ userPwd + "]";
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPwd() {
		return userPwd;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
}
