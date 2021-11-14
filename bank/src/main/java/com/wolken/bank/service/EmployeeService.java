package com.wolken.bank.service;

import java.util.List;

import com.wolken.bank.dto.EmployeeDTO;

public interface EmployeeService {	
	
	String validateAndCreate(EmployeeDTO dto);
	String validateAndWithdrawAccount(EmployeeDTO dto);
	List<EmployeeDTO> validateAndGetAll();
	String validateAndDeposit();
	String validateAndCloseAccount();
	List<EmployeeDTO> getEmployeeDetails();
	String validateAndSave(EmployeeDTO dto);
	List<EmployeeDTO> validateAndFindByName(String name);
	List<EmployeeDTO> validateAndFindByDesignation(String designation);
	List<EmployeeDTO> validateAndFindBySalary(float salary);
	String validateAndSaveAll(List<EmployeeDTO> dtos);
}
