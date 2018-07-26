package com.sun.magic.domain;

import java.io.Serializable;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月25日 上午11:55:32
 */
public class Movies implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String linkList;
	private String imgUrl ;
	private String title ;
	private String actor ;
	private String rate ;
	private String peoRate ;
	private String intr ;
	
	
	public String getLinkList() {
		return linkList;
	}
	
	public void setLinkList(String linkList) {
		this.linkList = linkList;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getActor() {
		return actor;
	}
	
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	public String getRate() {
		return rate;
	}
	
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	public String getPeoRate() {
		return peoRate;
	}
	
	public void setPeoRate(String peoRate) {
		this.peoRate = peoRate;
	}
	
	public String getIntr() {
		return intr;
	}
	
	public void setIntr(String intr) {
		this.intr = intr;
	}

	public Movies(int id, String linkList, String imgUrl, String title,
			String actor, String rate, String peoRate, String intr) {
		this.id = id;
		this.linkList = linkList;
		this.imgUrl = imgUrl;
		this.title = title;
		this.actor = actor;
		this.rate = rate;
		this.peoRate = peoRate;
		this.intr = intr;
	}
	
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public Movies(){
		
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", linkList=" + linkList
				+ ", imgUrl=" + imgUrl + ", title=" + title + ", actor="
				+ actor + ", rate=" + rate + ", peoRate=" + peoRate + ", intr="
				+ intr + "]";
	}
	
}
