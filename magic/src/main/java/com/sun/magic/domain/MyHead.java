package com.sun.magic.domain;

import java.io.Serializable;

public class MyHead implements Serializable {

	private static final long serialVersionUID = 1L;
	private String img;
	
	public MyHead() {
	}

	public MyHead(String img) {
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
