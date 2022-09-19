package com.emp.app.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.emp.app.dto.Notification;
import com.emp.app.util.BasicInfoHelper;

@RestControllerAdvice
public class BasicInfoExceptionHandler {
	@Autowired
	private BasicInfoHelper basicInfoHelper;

	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Notification> methodNotAllowedExceptionCase(HttpRequestMethodNotSupportedException exception, HttpServletRequest request){
		Notification notification = basicInfoHelper.buildNotification(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(), 
				HttpStatus.METHOD_NOT_ALLOWED.value(), exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(notification, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Notification> nullPointerException(NullPointerException exception, HttpServletRequest request){
		Notification notification = basicInfoHelper.buildNotification(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), 
				HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(notification, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> clientErrorException(MethodArgumentNotValidException exception, HttpServletRequest request){
		List<FieldError> fieldErrors = exception.getFieldErrors();
		Map<String, Object> map = new HashMap<>();
		for(FieldError fieldError : fieldErrors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}		
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Notification> exception(Exception exception, HttpServletRequest request){
		Notification notification = basicInfoHelper.buildNotification(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), 
				HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(notification, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
