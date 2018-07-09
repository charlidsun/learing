
package com.sun.shiroLearning.exception;
/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月9日 上午10:31:29
 */
public class ErrorResponseEntity {

	private int code;
	private String message;
	private static ErrorResponseEntity e = new ErrorResponseEntity(11, "222");
	
	public ErrorResponseEntity(){
	}
	
	public static ErrorResponseEntity getEErrorResponseEntity(){
		return e;
	}
	
	public ErrorResponseEntity(int code, String message) {
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
