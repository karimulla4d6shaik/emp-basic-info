package com.emp.app.service;

import org.springframework.security.authentication.AuthenticationManager;

import com.emp.app.dto.EmpBasicInfoRequestDto;
import com.emp.app.dto.LoginDto;
import com.emp.app.dto.LoginSuccessDto;
import com.emp.app.dto.SuccessResponseDto;

public interface EmpBasicInfoService {

	public SuccessResponseDto register(EmpBasicInfoRequestDto empBasicInfoRequestDto);

	public LoginSuccessDto login(LoginDto loginDto, AuthenticationManager authenticationManager);
}
