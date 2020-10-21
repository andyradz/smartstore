package com.codigo.smartstore.webapi.database;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codigo.smartstore.webapi.repository.EmployeeRepository;

@Component
public class DataLoader {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostConstruct
	public void init() {

		System.out.println("Database operations");
		// var entity = new Employee();
		// entity.setId(1L);
		// entity.setName("Max");
		// entity.setRole("Admin");
		// employeeRepository.save(entity);
	}
}
