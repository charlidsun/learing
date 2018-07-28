package com.sun.magic.domain.chat;

import java.io.Serializable;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月28日 下午4:14:29
 */
public class List implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fakeid;

	private String nickname;

	private String alias;

	private String round_head_img;

	private int service_type;

	public void setFakeid(String fakeid) {
		this.fakeid = fakeid;
	}

	public String getFakeid() {
		return this.fakeid;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setRound_head_img(String round_head_img) {
		this.round_head_img = round_head_img;
	}

	public String getRound_head_img() {
		return this.round_head_img;
	}

	public void setService_type(int service_type) {
		this.service_type = service_type;
	}

	public int getService_type() {
		return this.service_type;
	}
}
