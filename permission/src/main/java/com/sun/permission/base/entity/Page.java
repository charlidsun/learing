package com.sun.permission.base.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 分页
 * @author Administrator
 *
 */
@Data
public class Page implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("rawtypes")
	private List rows;
	private long total;
	
	public Page() {}
	
	public Page(List rows, long total) {
		super();
		this.rows = rows;
		this.total = total;
	}

}
