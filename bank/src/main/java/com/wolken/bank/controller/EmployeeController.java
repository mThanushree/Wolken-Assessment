package com.wolken.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.bank.dto.EmployeeDTO;
import com.wolken.bank.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private Logger logger = LoggerFactory.getLogger(BalanceController.class);
	
	@Autowired
	EmployeeService service;

	@PostMapping("saveEmployee")
	String save(@RequestBody EmployeeDTO dto) {
		String msg = null; 
		try {
			logger.info(""+dto);
			msg = service.validateAndSave(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}
	
	@GetMapping("findByName")
	List<EmployeeDTO>
	getByName(@RequestBody String name) {
		List<EmployeeDTO> dto = null;
		try {
			logger.info(name);
			dto = service.validateAndFindByName(name);
		} catch(Exception e) {
			logger.error("========= you have an exception in EmployeeController.getByName()=======");
			logger.error(e.getMessage(), e.getClass());
		}
		return dto;
	}
	
	@PostMapping("saveAll")
	String saveAll(@RequestBody List<EmployeeDTO> dto) {
		String msg=null;
		try {
			msg = service.validateAndSaveAll(dto);
		}catch (Exception e) {
			logger.info(e.getMessage(),e.getClass().getSimpleName());
		}
		return msg;
	}
	
	@GetMapping("getBySalary")
	List<EmployeeDTO> getBySalary(@RequestParam float salary) {
		List<EmployeeDTO> dto = null;
		try {
			dto=service.validateAndFindBySalary(salary);
		} catch (Exception e) {
			logger.info(e.getMessage(),e.getClass());
		}
		return dto;
	}
	
	@GetMapping("getByDesignation")
	List<EmployeeDTO> getByDesignation(@RequestParam String designation) {
		List<EmployeeDTO> dto = null;
		try {
			logger.info(designation);
			dto=service.validateAndFindByDesignation(designation);
		} catch (Exception e) {
			logger.info(e.getMessage(),e.getClass());
		}
		return dto;
	}
	
}
