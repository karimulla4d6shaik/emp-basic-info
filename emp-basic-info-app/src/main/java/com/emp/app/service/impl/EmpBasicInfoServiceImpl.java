package com.emp.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emp.app.config.JwtConfig;
import com.emp.app.constant.BasicInfoConstants;
import com.emp.app.dto.EmpBasicInfoRequestDto;
import com.emp.app.dto.LoginDto;
import com.emp.app.dto.LoginSuccessDto;
import com.emp.app.dto.Notification;
import com.emp.app.dto.SuccessResponseDto;
import com.emp.app.entity.CompaniesEntity;
import com.emp.app.entity.EmplyeeBasicInfoEntity;
import com.emp.app.repo.CompaniesRepo;
import com.emp.app.repo.EmpBasicInfoRepo;
import com.emp.app.service.EmpBasicInfoService;
import com.emp.app.util.BasicInfoHelper;

	
@Service
public class EmpBasicInfoServiceImpl implements EmpBasicInfoService, UserDetailsService {
	@Autowired
	private EmpBasicInfoRepo empBasicInfoRepo;
	@Autowired
	private BasicInfoHelper basicInfoHelper;
	@Autowired
	private CompaniesRepo companiesRepo;
	
	@Autowired
	private JwtConfig jwtConfig;

	@Override
	public SuccessResponseDto register(EmpBasicInfoRequestDto empBasicInfoRequestDto) {
		EmplyeeBasicInfoEntity emplyeeBasicInfoEntity = basicInfoHelper.convertToEntityObject(empBasicInfoRequestDto);
		empBasicInfoRepo.save(emplyeeBasicInfoEntity);
		Notification notification = basicInfoHelper.buildNotification(BasicInfoConstants.SUCCESS_STATUS, 
				BasicInfoConstants.SUCCESS_STATUS_CODE, BasicInfoConstants.SUCCESS_MESSAGE, "");
		return basicInfoHelper.convertToResponseObject(emplyeeBasicInfoEntity, notification);
	}

	@Override
	public LoginSuccessDto login(LoginDto loginDto, AuthenticationManager authenticationManager) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new 
				UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword());
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		UserDetailsImpl principal = (UserDetailsImpl)authentication.getPrincipal();
		LoginSuccessDto loginSuccessDto = new LoginSuccessDto();
		loginSuccessDto.setUserName(principal.getUsername());
		String token = jwtConfig.generateToken(principal);
		loginSuccessDto.setToken(token);
		return loginSuccessDto;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EmplyeeBasicInfoEntity emplyeeBasicInfoEntity = empBasicInfoRepo.findByUserName(username);
		if(emplyeeBasicInfoEntity == null)
			throw new UsernameNotFoundException("User not found with username "+username);
		
		return new UserDetailsImpl(emplyeeBasicInfoEntity);
	}
	
	@Override
	public SuccessResponseDto getDetailsByUsername(String userName) {
		EmplyeeBasicInfoEntity emplyeeBasicInfoEntity = empBasicInfoRepo.findByUserName(userName);
		if(emplyeeBasicInfoEntity == null)
			throw new UsernameNotFoundException("User not found with username "+userName);
		
		List<CompaniesEntity> companiesEntities = companiesRepo.findByEmplyeeBasicInfoEntity(emplyeeBasicInfoEntity);
		emplyeeBasicInfoEntity.setCompaniesEntities(companiesEntities);
		Notification notification = basicInfoHelper.buildNotification(BasicInfoConstants.GET_SUCCESS_STATUS, 
				BasicInfoConstants.GET_SUCCESS_STATUS_CODE, BasicInfoConstants.GET_SUCCESS_MESSAGE, "");
		return basicInfoHelper.convertToResponseObject(emplyeeBasicInfoEntity, notification);
	}

}
