package com.emp.app.dto;

import java.util.List;

public class EmpBasicInfoResponseDto {

	private Integer empBasicInfoId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String userName;
	private String phone;
	private String personalEmail;
	private Integer noOfCompanies;
	private List<String> companyNames;

	public Integer getEmpBasicInfoId() {
		return empBasicInfoId;
	}

	public void setEmpBasicInfoId(Integer empBasicInfoId) {
		this.empBasicInfoId = empBasicInfoId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public Integer getNoOfCompanies() {
		return noOfCompanies;
	}

	public void setNoOfCompanies(Integer noOfCompanies) {
		this.noOfCompanies = noOfCompanies;
	}

	public List<String> getCompanyNames() {
		return companyNames;
	}

	public void setCompanyNames(List<String> companyNames) {
		this.companyNames = companyNames;
	}

}
