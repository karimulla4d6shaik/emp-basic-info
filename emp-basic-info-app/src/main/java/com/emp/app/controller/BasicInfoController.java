package com.emp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.app.constant.PathConstants;
import com.emp.app.dto.EmpBasicInfoRequestDto;
import com.emp.app.dto.SuccessResponseDto;
import com.emp.app.service.EmpBasicInfoService;

@RestController
@RequestMapping(PathConstants.ROOT_LEVEL_PATH)
public class BasicInfoController {
	@Autowired
	private EmpBasicInfoService basicInfoService;

	@PostMapping
	public ResponseEntity<SuccessResponseDto> register(@RequestBody EmpBasicInfoRequestDto empBasicInfoRequestDto) {
		return new ResponseEntity<>(basicInfoService.register(empBasicInfoRequestDto), HttpStatus.OK);
	}
}
