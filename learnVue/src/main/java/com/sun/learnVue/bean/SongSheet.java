package com.sun.learnVue.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class SongSheet implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String imgUrl;
	
	public SongSheet(int id, String name, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.imgUrl = imgUrl;
	}
	
}
