package com.sun.permission.sys.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserAssociateRole implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int userId;
	private long roleId;

}
