package com.sun.nettyLearning.exception;
/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月17日 下午4:18:21
 */
public class ErrorResponseEntity {

	private int code;
	private String message;
	
	public ErrorResponseEntity() {
	}
	
	public ErrorResponseEntity(int code,String message){
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
