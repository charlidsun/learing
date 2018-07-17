package com.sun.nettyLearning.exception;
/**
 * 功能：自定义异常
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月17日 下午4:10:13
 */
public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private int code;

	public CustomException(){
		super();
	}
	
	public CustomException(int code,String message){
		super(message);
		this.code = code;
	}
	
	
	public int getCode() {
		return code;
	}

	
	public void setCode(int code) {
		this.code = code;
	}
	
	

}
