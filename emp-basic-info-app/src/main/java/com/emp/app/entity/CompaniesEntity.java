package com.emp.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANIES_TBL")
public class CompaniesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMP_ID")
	private Integer companyId;
	@Column(name = "COMP_NAME", length = 25, nullable = false)
	private String companyName;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_BASIC_INFO_ID", nullable = false)
	private EmplyeeBasicInfoEntity emplyeeBasicInfoEntity;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public EmplyeeBasicInfoEntity getEmplyeeBasicInfoEntity() {
		return emplyeeBasicInfoEntity;
	}

	public void setEmplyeeBasicInfoEntity(EmplyeeBasicInfoEntity emplyeeBasicInfoEntity) {
		this.emplyeeBasicInfoEntity = emplyeeBasicInfoEntity;
	}

}
