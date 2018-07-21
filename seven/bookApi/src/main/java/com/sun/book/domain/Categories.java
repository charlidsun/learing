package com.sun.book.domain;

import java.io.Serializable;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月21日 上午11:37:40
 */
public class Categories implements Serializable{

	private static final long serialVersionUID = 3702543784953199982L;
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
