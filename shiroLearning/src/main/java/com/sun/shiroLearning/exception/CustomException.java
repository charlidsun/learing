package com.sun.shiroLearning.exception;
/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月9日 上午10:23:25
 */
public class CustomException extends RuntimeException{

	private static final long serialVersionUID = -2934138714976217542L;
	private int code;
	
	public CustomException (){
		super();
	}
	
	public CustomException(int code,String message){
		super(message);
		this.code = code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
}
