package com.sun.nettyLearning.entity;
/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月13日 下午4:25:12
 */
public class TransMsg {

	private int mgsType;
	private String userId;
	private String toUserId;
	private String msg;
	
	public TransMsg() {
	}
	
	public TransMsg(int mgsType, String userId, String toUserId, String msg) {
		this.mgsType = mgsType;
		this.userId = userId;
		this.toUserId = toUserId;
		this.msg = msg;
	}

	public int getMgsType() {
		return mgsType;
	}
	
	public void setMgsType(int mgsType) {
		this.mgsType = mgsType;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getToUserId() {
		return toUserId;
	}
	
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	@Override
	public String toString() {
		return "TransMsg [mgsType=" + mgsType + ", userId=" + userId
				+ ", toUserId=" + toUserId + ", msg=" + msg + "]";
	}
	
}
