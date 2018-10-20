package com.sun.permission.sys.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserRole implements Serializable{


	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String roleName;
	
}
