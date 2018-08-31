package com.sun.learnVue.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Recommend implements Serializable{


	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private List<SongSheet> songSheetList;
	
	public Recommend(int id, String name, List<SongSheet> songSheetList) {
		super();
		this.id = id;
		this.name = name;
		this.songSheetList = songSheetList;
	}
	
	
}
