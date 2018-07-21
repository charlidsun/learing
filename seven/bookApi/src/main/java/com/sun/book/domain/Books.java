 package com.sun.book.domain;

import java.io.Serializable;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月21日 上午11:33:09
 */
public class Books implements Serializable{

	private static final long serialVersionUID = 8297862821480676886L;
	private int id;
	private String title;
	private String author;
	private String publishYear;
	private String coverImg;
	private String introduction;
	private String content;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublishYear() {
		return publishYear;
	}
	
	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}
	
	public String getCoverImg() {
		return coverImg;
	}
	
	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
