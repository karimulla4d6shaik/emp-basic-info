package com.emp.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.app.entity.EmplyeeBasicInfoEntity;

public interface EmpBasicInfoRepo extends JpaRepository<EmplyeeBasicInfoEntity, Integer>{

}
