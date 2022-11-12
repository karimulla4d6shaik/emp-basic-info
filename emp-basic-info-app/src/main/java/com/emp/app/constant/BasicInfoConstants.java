package com.emp.app.constant;

import org.springframework.http.HttpStatus;

public class BasicInfoConstants {

	private BasicInfoConstants() {
		
	}
	
	public static final String SUCCESS_STATUS = HttpStatus.CREATED.getReasonPhrase();
	public static final Integer SUCCESS_STATUS_CODE = HttpStatus.CREATED.value();
	public static final String SUCCESS_MESSAGE = "Employee baisc information saved successfully";
	
	public static final String FAILURE_STATUS = HttpStatus.BAD_REQUEST.getReasonPhrase();
	public static final Integer FAILURE_STATUS_CODE = HttpStatus.BAD_REQUEST.value();
	public static final String FAILURE_MESSAGE = "Some thing went worng, Please try after some time";
	
	public static final String GET_SUCCESS_STATUS = HttpStatus.OK.getReasonPhrase();
	public static final Integer GET_SUCCESS_STATUS_CODE = HttpStatus.OK.value();
	public static final String GET_SUCCESS_MESSAGE = "Details retrived successfully";
}
