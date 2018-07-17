package com.sun.nettyLearning.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 功能：捕获全局异常 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月17日 下午4:24:04
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * 
	 * 功能： 定义要捕获的异常
	 * @Description: 
	 * @param: @param request
	 * @param: @param e
	 * @param: @param response
	 * @param: @return      
	 * @return: ErrorResponseEntity 
	 * @author : 孙荆阁
	 * @Date 2018年7月17日 下午5:15:44  
	 * 修改日期 修改人 修改内容
	 * <多次修改需另起一行>
	 */
	@ExceptionHandler(CustomException.class)
	public ErrorResponseEntity customExceptionHandler(HttpServletRequest request, final Exception e,
			HttpServletResponse response) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		CustomException exception = (CustomException) e;
		return new ErrorResponseEntity(exception.getCode(),exception.getMessage());
	}
	
	/**
	 * 
	 * 功能：捕获运行时的时长 
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param request
	 * @param: @param e
	 * @param: @param response
	 * @param: @return      
	 * @return: ErrorResponseEntity 
	 * @author : 孙荆阁
	 * @Date 2018年7月17日 下午5:21:47  
	 * 修改日期 修改人 修改内容
	 * <多次修改需另起一行>
	 */
	@ExceptionHandler(RuntimeException.class)
    public ErrorResponseEntity runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        RuntimeException exception = (RuntimeException) e;
        return new ErrorResponseEntity(400, exception.getMessage());
    }
	
	 /**
     * 通用的接口映射异常处理方
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            return new ResponseEntity<>(new ErrorResponseEntity(status.value(), exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()), status);
        }
        if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            logger.error("参数转换失败，方法：" + exception.getParameter().getMethod().getName() + "，参数：" + exception.getName()
                    + ",信息：" + exception.getLocalizedMessage());
            return new ResponseEntity<>(new ErrorResponseEntity(status.value(), "参数转换失败"), status);
        }
        return new ResponseEntity<>(new ErrorResponseEntity(status.value(), "参数转换失败"), status);
    }
}
