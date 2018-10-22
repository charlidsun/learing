package com.sun.permission.sys.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class User implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String login;
	private String password;
	private String userName;
	private String address;
	private String job;
	private long groupId;
	private Date birthDate;
	private String city;
	private String district;
	private String province;
	private String streetAddress;
	private String state;
	private String type;
	private Date lastLoginDate;
	
	public User(){
		super();
	}
 
	public User(int id){
		this.id = id;
	}

	// 用户角色信息
	private List<UserRole> roles;
	// 权限集合数据
	private String roleArray;


	// 重写方法1
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		if(this.getRoles()!=null){
			List<UserRole> roles=this.getRoles();
			for(UserRole role:roles){
				if(role.getName()!=null){
					auths.add(new SimpleGrantedAuthority(role.getName()));
				}
			}
		}
		return auths;
	}
	
	public void packagingRoles(String roleArray){
		List<UserRole> roles = new ArrayList<UserRole>();
		if(roleArray!=null){
			UserRole userRole = null;
			for(String roleId:roleArray.split(",")){
				if(!roleId.isEmpty()){
					userRole = new UserRole();
					userRole.setId(Long.parseLong(roleId));
					roles.add(userRole);
				}
			}
		}
		this.setRoles(roles);
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
