package com.codigo.smartstore.webapi.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.codigo.smartstore.webapi.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
// @RunWith(SpringRunner.class)
@DataJpaTest
// @TestPropertySource(properties = { "spring.jpa.hibernate.ddl-auto=validate"
// })
@EnableAutoConfiguration
@ContextConfiguration(classes = TestBean.class)
@WebAppConfiguration
// https://stackabuse.com/spring-annotations-testing/
public class EmployeeRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// @Autowired
	// private EntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void injectedComponentsAreNotNull() {

		assertThat(this.dataSource).isNotNull();
		assertThat(this.jdbcTemplate).isNotNull();
		assertThat(this.entityManager).isNotNull();
		assertThat(this.employeeRepository).isNotNull();

		System.out.println(this.employeeRepository.count());
	}

}