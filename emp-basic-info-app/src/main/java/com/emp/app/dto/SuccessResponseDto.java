package com.emp.app.dto;

public class SuccessResponseDto {

	private EmpBasicInfoResponseDto empBasicInfoResponseDto;
	private Notification notification;

	public EmpBasicInfoResponseDto getEmpBasicInfoResponseDto() {
		return empBasicInfoResponseDto;
	}

	public void setEmpBasicInfoResponseDto(EmpBasicInfoResponseDto empBasicInfoResponseDto) {
		this.empBasicInfoResponseDto = empBasicInfoResponseDto;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

}
