 package com.sun.esLearn.entity;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月20日 下午3:59:07
 */
@Document(indexName = "province", type = "city")
public class City implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String description;
	private Integer score;
	
	public City(){
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param score
	 */
	public City(Long id, String name, String description, Integer score) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.score = score;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}
	
	
	
}
