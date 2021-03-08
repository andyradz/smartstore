package com.codigo.smartstore.webapi.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes =
// SmartstoreWebapiApplication.class)
// @EnableConfigurationProperties(value = ServerConfig.class)
// @ContextConfiguration(classes = ServerConfigFactory.class)
@WebMvcTest(value = EmployeeController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class EmployeeRestControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	// @MockBean
	// private EmployeeService service;

	@Test
	void test() {

	}

	// @Test
	// public void whenPostEmployee_thenCreateEmployee() throws Exception {
	// Employee alex = new Employee("alex");
	// given(service.save(Mockito.any())).willReturn(alex);
	//
	// mvc.perform(post("/api/employees").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(alex))).andExpect(status().isCreated()).andExpect(jsonPath("$.name",
	// is("alex")));
	// verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
	// reset(service);
	// }
	//
	// @Test
	// public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws
	// Exception {
	// Employee alex = new Employee("alex");
	// Employee john = new Employee("john");
	// Employee bob = new Employee("bob");
	//
	// List<Employee> allEmployees = Arrays.asList(alex, john, bob);
	//
	// given(service.getAllEmployees()).willReturn(allEmployees);
	//
	// mvc.perform(get("/api/employees").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$",
	// hasSize(3))).andExpect(jsonPath("$[0].name",
	// is(alex.getName()))).andExpect(jsonPath("$[1].name", is(john.getName())))
	// .andExpect(jsonPath("$[2].name", is(bob.getName())));
	// verify(service, VerificationModeFactory.times(1)).getAllEmployees();
	// reset(service);
	// }

}
