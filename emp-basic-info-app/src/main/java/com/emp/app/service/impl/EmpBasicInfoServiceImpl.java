package com.emp.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.app.constant.BasicInfoConstants;
import com.emp.app.dto.EmpBasicInfoRequestDto;
import com.emp.app.dto.Notification;
import com.emp.app.dto.SuccessResponseDto;
import com.emp.app.entity.EmplyeeBasicInfoEntity;
import com.emp.app.repo.EmpBasicInfoRepo;
import com.emp.app.service.EmpBasicInfoService;
import com.emp.app.util.BasicInfoHelper;

	
@Service
public class EmpBasicInfoServiceImpl implements EmpBasicInfoService {
	@Autowired
	private EmpBasicInfoRepo empBasicInfoRepo;
	@Autowired
	private BasicInfoHelper basicInfoHelper;

	@Override
	public SuccessResponseDto register(EmpBasicInfoRequestDto empBasicInfoRequestDto) {
		EmplyeeBasicInfoEntity emplyeeBasicInfoEntity = basicInfoHelper.convertToEntityObject(empBasicInfoRequestDto);
		empBasicInfoRepo.save(emplyeeBasicInfoEntity);
		Notification notification = basicInfoHelper.buildNotification(BasicInfoConstants.SUCCESS_STATUS, 
				BasicInfoConstants.SUCCESS_STATUS_CODE, BasicInfoConstants.SUCCESS_MESSAGE, "");
		return basicInfoHelper.convertToResponseObject(emplyeeBasicInfoEntity, notification);
	}

}
