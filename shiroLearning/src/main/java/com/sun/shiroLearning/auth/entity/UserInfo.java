package com.sun.shiroLearning.auth.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年6月30日 上午11:10:03
 */
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int uid;
	private String username;
	private String name;
	private String password;
	private String salt;
	private byte state;
	// 角色
	private List<SysRole> userRole;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public byte getState() {
		return state;
	}

	public String getCredentialsSalt() {
		return this.username + this.salt;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public List<SysRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<SysRole> userRole) {
		this.userRole = userRole;
	}


	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", username=" + username + ", name="
				+ name + ", password=" + password + ", salt=" + salt
				+ ", state=" + state + "]";
	}

}
