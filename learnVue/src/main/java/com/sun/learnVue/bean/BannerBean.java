package com.sun.learnVue.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class BannerBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String imgUrl;
	private String name;
	
	public BannerBean(int id, String name,String imgUrl) {
		super();
		this.id = id;
		this.imgUrl = imgUrl;
		this.name = name;
	}
	
	
}
