package com.wolken.bank.controller;

import org.springframework.web.bind.annotation.RestController;

import com.wolken.bank.dto.EmployeeDTO;
import com.wolken.bank.service.EmployeeService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BalanceController {
 
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EmployeeService service;
	
	@GetMapping("getAccountDetails")
	String getAccountDetails() {
		logger.info("Details of Account");
		return "Customer name-Thanushree" + 
	           "Account type-Savings" +
	           "Bank name-SBI";
		
	}
	
	@PostMapping("createAccount")
	String create(@RequestBody EmployeeDTO dto) {
		String msg=null;
		try {
			msg = service.validateAndCreate(dto);
			logger.info(""+dto);
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return msg;
	}
	
	@PostMapping("withdrawAmount")
	String withdraw(@RequestBody EmployeeDTO dto) {
		String msg = null;
		try {
			logger.info("withdraw amount:"+dto);
			msg = service.validateAndWithdrawAccount(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}
	
	@PostMapping("depositAmount")
	String deposite(@RequestBody EmployeeDTO dto) {
		String msg = null;
		try {
			logger.info("deposit amount" + dto);
			msg = service.validateAndDeposit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}
	

	@GetMapping("getBalance")
	List<EmployeeDTO> getBalance() {
		List<EmployeeDTO> list = service.validateAndGetAll();
		logger.info("" + list);
		return list;
	}
	
	@PutMapping("closeAccount")
	String closeAccount(@RequestBody EmployeeDTO dto) {
		String msg = null;
		try {
			logger.info("dto" + dto);
			msg = service.validateAndCloseAccount();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}
	
}
