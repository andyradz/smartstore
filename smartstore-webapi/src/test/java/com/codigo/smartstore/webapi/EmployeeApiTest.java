package com.codigo.smartstore.webapi;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.codigo.smartstore.webapi.domain.Employee;

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeApiTest {

	private final static String urlAddress = "http://localhost:8080/api/v1/employees/1";

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;

	@Test
	@Disabled
	public void test1() {

		final ResponseEntity<Employee> entity = this.testRestTemplate.getForEntity(urlAddress, Employee.class);

		assertThat(entity.getStatusCode(), is(HttpStatus.OK));

	}

}
