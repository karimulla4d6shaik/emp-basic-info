package com.emp.app.service;

import com.emp.app.dto.EmpBasicInfoRequestDto;
import com.emp.app.dto.SuccessResponseDto;

public interface EmpBasicInfoService {

	public SuccessResponseDto register(EmpBasicInfoRequestDto empBasicInfoRequestDto);

}
