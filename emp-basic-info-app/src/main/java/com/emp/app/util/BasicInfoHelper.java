package com.emp.app.util;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.emp.app.dto.EmpBasicInfoRequestDto;
import com.emp.app.dto.EmpBasicInfoResponseDto;
import com.emp.app.dto.Notification;
import com.emp.app.dto.SuccessResponseDto;
import com.emp.app.entity.CompaniesEntity;
import com.emp.app.entity.EmplyeeBasicInfoEntity;

@Service
public class BasicInfoHelper {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public EmplyeeBasicInfoEntity convertToEntityObject(EmpBasicInfoRequestDto empBasicInfoRequestDto) {
		EmplyeeBasicInfoEntity emplyeeBasicInfoEntity = new EmplyeeBasicInfoEntity();
		emplyeeBasicInfoEntity.setFirstName(empBasicInfoRequestDto.getFirstName());
		emplyeeBasicInfoEntity.setLastName(empBasicInfoRequestDto.getLastName());
		emplyeeBasicInfoEntity.setMiddleName(empBasicInfoRequestDto.getMiddleName());
		emplyeeBasicInfoEntity.setNoOfCompanies(empBasicInfoRequestDto.getNoOfCompanies());
		emplyeeBasicInfoEntity.setPersonalEmail(empBasicInfoRequestDto.getPersonalEmail());
		emplyeeBasicInfoEntity.setPhone(empBasicInfoRequestDto.getPhone());		
		emplyeeBasicInfoEntity.setUserName(empBasicInfoRequestDto.getUserName());	
		emplyeeBasicInfoEntity.setPassword(passwordEncoder.encode("ASDFG"));
		List<CompaniesEntity> companiesEntities = new ArrayList<>();
		for(String cn : empBasicInfoRequestDto.getCompanyNames()) {
			CompaniesEntity companiesEntity = new CompaniesEntity();
			companiesEntity.setCompanyName(cn);
			companiesEntity.setEmplyeeBasicInfoEntity(emplyeeBasicInfoEntity);
			companiesEntities.add(companiesEntity);
		}		
		emplyeeBasicInfoEntity.setCompaniesEntities(companiesEntities);
		return emplyeeBasicInfoEntity;
	}

	public SuccessResponseDto convertToResponseObject(EmplyeeBasicInfoEntity emplyeeBasicInfoEntity, Notification notification) {
		SuccessResponseDto successResponseDto = new SuccessResponseDto();
		EmpBasicInfoResponseDto empBasicInfoResponseDto = new EmpBasicInfoResponseDto();
		empBasicInfoResponseDto
		.setCompanyNames(emplyeeBasicInfoEntity.getCompaniesEntities().stream().map(CompaniesEntity::getCompanyName).collect(Collectors.toList()));
		empBasicInfoResponseDto.setEmpBasicInfoId(emplyeeBasicInfoEntity.getEmpBasicInfoId());
		empBasicInfoResponseDto.setFirstName(emplyeeBasicInfoEntity.getFirstName());
		empBasicInfoResponseDto.setLastName(emplyeeBasicInfoEntity.getLastName());
		empBasicInfoResponseDto.setMiddleName(emplyeeBasicInfoEntity.getMiddleName());
		empBasicInfoResponseDto.setNoOfCompanies(emplyeeBasicInfoEntity.getNoOfCompanies());
		empBasicInfoResponseDto.setPersonalEmail(emplyeeBasicInfoEntity.getPersonalEmail());
		empBasicInfoResponseDto.setPhone(emplyeeBasicInfoEntity.getPhone());
		empBasicInfoResponseDto.setUserName(emplyeeBasicInfoEntity.getUserName());
		successResponseDto.setEmpBasicInfoResponseDto(empBasicInfoResponseDto);
		successResponseDto.setNotification(notification);
		return successResponseDto;
	}
	
	public Notification buildNotification(String status, Integer statusCode, String message, String path) {
		Notification notification = new Notification();
		notification.setMessage(message);
		notification.setPath(path);
		notification.setStatus(status);
		notification.setStatusCode(statusCode);
		notification.setTime(LocalTime.now());
		return notification;
	}

}
