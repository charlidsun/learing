package com.sun.shiroLearning.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月9日 上午10:40:28
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// 定义要捕获的异常 可以多个 @ExceptionHandler({})
	@ExceptionHandler(CustomException.class)
	public ErrorResponseEntity customExceptionHandler(
			HttpServletRequest request, final Exception e,
			HttpServletResponse response) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		CustomException customException = (CustomException) e;
		return new ErrorResponseEntity(customException.getCode(),
				customException.getMessage());
	}

	// 捕获 RuntimeException 异常
	@ExceptionHandler(RuntimeException.class)
	public ErrorResponseEntity runtimeExceptionHandler(
			HttpServletRequest request, final RuntimeException e,
			HttpServletResponse response) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		RuntimeException runtimeException = (RuntimeException) e;
		return new ErrorResponseEntity(400, runtimeException.getMessage());
	}

	//通用的接口映射异常处理方
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
			Object body, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		if (ex instanceof NullPointerException){
			NullPointerException exception = (NullPointerException) ex;
			return new ResponseEntity<>(new ErrorResponseEntity(status.value(),
					exception.getMessage()), status);
		}
		
		if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
			return new ResponseEntity<>(new ErrorResponseEntity(status.value(),
					exception.getBindingResult().getAllErrors().get(0)
							.getDefaultMessage()), status);
		}
		if (ex instanceof MethodArgumentTypeMismatchException) {
			MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
			logger.error("参数转换失败，方法："
					+ exception.getParameter().getMethod().getName() + "，参数："
					+ exception.getName() + ",信息："
					+ exception.getLocalizedMessage());
			return new ResponseEntity<>(new ErrorResponseEntity(status.value(),
					"参数转换失败"), status);
		}
		return new ResponseEntity<>(new ErrorResponseEntity(status.value(),
				"参数转换失败"), status);
	}
}
