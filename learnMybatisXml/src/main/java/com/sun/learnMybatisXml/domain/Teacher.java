package com.sun.learnMybatisXml.domain;

import java.io.Serializable;

public class Teacher implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	
	public Teacher() {
		
	}

	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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
