package com.emp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.app.constant.PathConstants;
import com.emp.app.dto.EmpBasicInfoRequestDto;
import com.emp.app.dto.LoginDto;
import com.emp.app.dto.LoginSuccessDto;
import com.emp.app.dto.SuccessResponseDto;
import com.emp.app.service.EmpBasicInfoService;

@RestController
@RequestMapping(PathConstants.ROOT_LEVEL_PATH)
public class BasicInfoController {
	@Autowired
	private EmpBasicInfoService basicInfoService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping
	public ResponseEntity<SuccessResponseDto> register(@RequestBody EmpBasicInfoRequestDto empBasicInfoRequestDto) {
		return new ResponseEntity<>(basicInfoService.register(empBasicInfoRequestDto), HttpStatus.OK);
	}
	
	@PostMapping(PathConstants.LOGIN_PATH)
	public ResponseEntity<LoginSuccessDto> login(@RequestBody LoginDto loginDto){
		return new ResponseEntity<>(basicInfoService.login(loginDto, authenticationManager), HttpStatus.OK);
	}
	
	@GetMapping(PathConstants.DETAILS_PATH)
	public ResponseEntity<SuccessResponseDto> getDetailsByUsername(@PathVariable("username") String userName) {
		return new ResponseEntity<>(basicInfoService.getDetailsByUsername(userName), HttpStatus.OK);
	}
}
