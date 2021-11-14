package com.wolken.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.wolken.bank.entity.AccountEntity;

public interface AccountRepo extends JpaRepositoryImplementation<AccountEntity, Integer> {
	
	AccountEntity findBalanceByHolderName(String holderName);
	List<AccountEntity> findAccountByBranchName(String branchName);
	AccountEntity findByAccountNo(long accountNo);
	
}