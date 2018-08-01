package com.sun.magic.domain.article;

import java.util.List;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年8月1日 下午1:17:42
 */
public class ArticelBean {
	private int app_msg_cnt;
	private List<App_msg_list> app_msg_list;
	private Base_resp base_resp;

	public void setApp_msg_cnt(int app_msg_cnt) {
		this.app_msg_cnt = app_msg_cnt;
	}

	public int getApp_msg_cnt() {
		return app_msg_cnt;
	}

	public void setApp_msg_list(List<App_msg_list> app_msg_list) {
		this.app_msg_list = app_msg_list;
	}

	public List<App_msg_list> getApp_msg_list() {
		return app_msg_list;
	}

	public void setBase_resp(Base_resp base_resp) {
		this.base_resp = base_resp;
	}

	public Base_resp getBase_resp() {
		return base_resp;
	}
}
