package com.sun.nettyLearning.chat.entity;

public class ChatHistory {

	private int id;
	private String sendUserId;
	private String sendUserName;
	private String receiveUserId;
	private String receiveUserName;
	private String content;
	private String create_time;
	private String sendUserImg;
	private String receiveUserImg;
	
	public String getSendUserImg() {
		return sendUserImg;
	}
	public void setSendUserImg(String sendUserImg) {
		this.sendUserImg = sendUserImg;
	}
	public String getReceiveUserImg() {
		return receiveUserImg;
	}
	public void setReceiveUserImg(String receiveUserImg) {
		this.receiveUserImg = receiveUserImg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}
	public String getSendUserName() {
		return sendUserName;
	}
	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}
	
	public String getReceiveUserId() {
		return receiveUserId;
	}
	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}
	public String getReceiveUserName() {
		return receiveUserName;
	}
	public void setReceiveUserName(String receiveUserName) {
		this.receiveUserName = receiveUserName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	
}
