package com.wolken.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@ToString

public class EmployeeEntity {
	
	@Id
	@GenericGenerator(name="employeeid", strategy="increment")
	@GeneratedValue(generator="employeeid")
	private int id;
	private String name;
	private String designation;
	private long contactNumber;
	private float salary;
	private String email;
	
}
