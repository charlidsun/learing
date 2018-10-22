package com.sun.permission.sys.entity;

import java.io.Serializable;

import com.sun.permission.base.entity.QueryBase;

import lombok.Data;

/**
 * 查询
 **/

@Data
public class QueryUser extends QueryBase implements Serializable{
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private String userName;
	private String address;
	private String job;
	private Long groupId;
	private String birthDate;
	private String city;
	private String district;
	private String province;
	private String streetAddress;
	private String state;
	private String type;
	private String lastLoginDate;

}
