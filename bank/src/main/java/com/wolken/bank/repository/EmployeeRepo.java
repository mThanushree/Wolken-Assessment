package com.wolken.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.bank.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {
	
	List<EmployeeEntity> findByName(String name);
	List<EmployeeEntity> findByDesignation(String designation);
	List<EmployeeEntity> findBySalary(float salary);
	EmployeeEntity findById(int id);
	
}
