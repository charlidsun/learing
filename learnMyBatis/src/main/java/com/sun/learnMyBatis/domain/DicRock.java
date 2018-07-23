package com.sun.learnMyBatis.domain;

import java.io.Serializable;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月23日 上午9:09:42
 */
public class DicRock implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String title;
	private String headImg;
	private String netUrl;
	private String createTime;
	private int sort;
	
	public DicRock() {
	}

	public DicRock(Integer id, String name, String headImg, String netUrl,
			String createTime, int sort) {
		super();
		this.id = id;
		this.name = name;
		this.headImg = headImg;
		this.netUrl = netUrl;
		this.createTime = createTime;
		this.sort = sort;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getHeadImg() {
		return headImg;
	}
	
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getNetUrl() {
		return netUrl;
	}
	
	public void setNetUrl(String netUrl) {
		this.netUrl = netUrl;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public int getSort() {
		return sort;
	}
	
	public void setSort(int sort) {
		this.sort = sort;
	}

	
	@Override
	public String toString() {
		return "DicRock [id=" + id + ", name=" + name + ", title=" + title
				+ ", headImg=" + headImg + ", netUrl=" + netUrl
				+ ", createTime=" + createTime + ", sort=" + sort + "]";
	}
	
}
