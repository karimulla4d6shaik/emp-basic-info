package com.emp.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.app.entity.CompaniesEntity;
import com.emp.app.entity.EmplyeeBasicInfoEntity;

public interface CompaniesRepo extends JpaRepository<CompaniesEntity, Integer>{

	List<CompaniesEntity> findByEmplyeeBasicInfoEntity(EmplyeeBasicInfoEntity emplyeeBasicInfoEntity);
}
