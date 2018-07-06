 package com.sun.shiroLearning.auth.entity;
/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月6日 上午10:30:01
 */
public class UserInfo {

    private Long id;
    private String username;
    private String password;
    private String roleName;
    private boolean locked;
    
    
	public UserInfo() {
	}
	
	public UserInfo(Long id, String username, String password, String roleName,
			boolean locked) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleName = roleName;
		this.locked = locked;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
    
    
}
