package com.sun.nettyLearning.user.entity;

public class UserInfo {

	private int id;
	private String loginName;
	private String loginPwd;
	private String salt;
	private int lock;
	private String userName;
	private String phone;
	private String gender;
	private String headImg;
	private String selfIntr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getLock() {
		return lock;
	}

	public void setLock(int lock) {
		this.lock = lock;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getSelfIntr() {
		return selfIntr;
	}

	public void setSelfIntr(String selfIntr) {
		this.selfIntr = selfIntr;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", loginName=" + loginName + ", loginPwd=" + loginPwd + ", salt=" + salt
				+ ", lock=" + lock + ", userName=" + userName + ", phone=" + phone + ", gender=" + gender + ", headImg="
				+ headImg + ", selfIntr=" + selfIntr + "]";
	}
}
