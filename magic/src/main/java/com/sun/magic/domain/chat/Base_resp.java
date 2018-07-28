package com.sun.magic.domain.chat;

import java.io.Serializable;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月28日 下午4:13:38
 */
public class Base_resp implements Serializable{

	private static final long serialVersionUID = 1L;

	private int ret;

	private String err_msg;

	public void setRet(int ret) {
		this.ret = ret;
	}

	public int getRet() {
		return this.ret;
	}

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}

	public String getErr_msg() {
		return this.err_msg;
	}

}
