package com.sun.magic.domain.article;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年8月1日 下午1:15:57
 */
public class Base_resp {
	private String err_msg;
	private int ret;

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}

	public String getErr_msg() {
		return err_msg;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public int getRet() {
		return ret;
	}
}