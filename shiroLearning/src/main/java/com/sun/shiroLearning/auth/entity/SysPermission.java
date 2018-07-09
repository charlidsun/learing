package com.sun.shiroLearning.auth.entity;

import java.io.Serializable;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月2日 下午1:46:34
 */
public class SysPermission implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;// 主键.
	private String name;// 名称.

	private String resourceType;// 资源类型，[menu|button]
	private String url;// 资源路径.
	private String permission; // 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
	private Long parentId; // 父编号
	private String parentIds; // 父编号列表
	private Boolean available = Boolean.FALSE;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the resourceType
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * @param resourceType
	 *            the resourceType to set
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the permission
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * @param permission
	 *            the permission to set
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the parentIds
	 */
	public String getParentIds() {
		return parentIds;
	}

	/**
	 * @param parentIds
	 *            the parentIds to set
	 */
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	/**
	 * @return the available
	 */
	public Boolean getAvailable() {
		return available;
	}

	/**
	 * @param available
	 *            the available to set
	 */
	public void setAvailable(Boolean available) {
		this.available = available;
	}

}
