package com.codigo.smartstore.webapi.services;

import java.util.Iterator;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codigo.smartstore.database.repository.GenericRepository;
import com.codigo.smartstore.webapi.domain.Employee;

@Service
public class EmployeeService {

	private static Logger log = LoggerFactory.getLogger(EmployeeService.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Inject
	private RestTemplate restTemplate;

	@Inject
	public EmployeeService() throws Exception {

	}

	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}

	@Bean
	public GenericRepository<Employee> genericRepository() throws Exception {

		return new GenericRepository<>(this.entityManager, Employee.class, "smartstore-database");
	}

	// @Transactional
	public Iterator<Employee> findEmployee() throws Exception {

		return this.genericRepository()
				.selectAll();

	}

	@Async("asyncExecutor")
	public CompletableFuture<Employee> getEmployeeName() throws InterruptedException {

		log.info("getEmployeeName starts");

		final Employee employeeNameData = this.restTemplate.getForObject("http://localhost:8080/name", Employee.class);

		log.info("employeeNameData, {}", employeeNameData);
		Thread.sleep(1000L); // Intentional delay
		log.info("employeeNameData completed");
		return CompletableFuture.completedFuture(employeeNameData);
	}

	@Async("asyncExecutor")
	public CompletableFuture<Employee> getEmployeeAddress() throws InterruptedException {

		log.info("getEmployeeAddress starts");

		final Employee employeeAddressData = this.restTemplate.getForObject("https://reqres.in/api/users?page=2",
			Employee.class);

		log.info("employeeAddressData, {}", employeeAddressData);
		Thread.sleep(1000L); // Intentional delay
		log.info("employeeAddressData completed");
		return CompletableFuture.completedFuture(employeeAddressData);
	}

	@Async("asyncExecutor")
	public CompletableFuture<Employee> getEmployeePhone() throws InterruptedException {

		log.info("getEmployeePhone starts");

		final Employee employeePhoneData = this.restTemplate.getForObject("http://localhost:8080/phone",
			Employee.class);

		log.info("employeePhoneData, {}", employeePhoneData);
		Thread.sleep(1000L); // Intentional delay
		log.info("employeePhoneData completed");
		return CompletableFuture.completedFuture(employeePhoneData);
	}
}