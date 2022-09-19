package com.emp.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_BASIC_INFO_TBL")
public class EmplyeeBasicInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_BASIC_INFO_ID")
	private Integer empBasicInfoId;
	@Column(name = "FIRST_NAME", length = 20, nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", length = 15, nullable = false)
	private String lastName;
	@Column(name = "MIDDLE_NAME", length = 15)
	private String middleName;
	@Column(name = "USER_NAME", length = 20, nullable = false, unique = true)
	private String userName;
	@Column(name = "PHONE", length = 15, nullable = false, unique = true)
	private String phone;
	@Column(name = "PERSONAL_EMAIL", length = 50, nullable = false, unique = true)
	private String personalEmail;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "NO_OF_COMPANIES", length = 20, nullable = false)
	private Integer noOfCompanies;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "companyId")
	private List<CompaniesEntity> companiesEntities = new ArrayList<>();

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public List<CompaniesEntity> getCompaniesEntities() {
		return companiesEntities;
	}

	public void setCompaniesEntities(List<CompaniesEntity> companiesEntities) {
		this.companiesEntities = companiesEntities;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

}
