package com.codigo.smartstore.webapi.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.codigo.smartstore.webapi.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

// @ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
// @TestPropertySource(locations = "/foo.properties")
class TestEmployeeControllerModelAttributeIntegration {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private EmployeeService service;

	@Test
	void shouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk());
		// .andExpect(content().string(containsString("Hello, World")));
	}

	@Test
	public void givenUrlEncodedFormData_whenAddEmployeeEndpointCalled_thenModelContainsMsgAttribute() throws Exception {

		// final Collection<NameValuePair> formData = Arrays.asList(new
		// BasicNameValuePair("name", "employeeName"),
		// new BasicNameValuePair("id", "99"),
		// new BasicNameValuePair("contactNumber", "123456789"));
		// final String urlEncodedFormData = EntityUtils.toString(new
		// UrlEncodedFormEntity(formData));
		//
		// this.mockMvc.perform(post("/addEmployee").contentType(MediaType.APPLICATION_FORM_URLENCODED)
		// // .content(urlEncodedFormData))
		// .andExpect(status().isOk())
		// .andExpect(view().name("employeeView")));
		// .andExpect(model().attribute("msg", "Welcome to the Netherlands!"));
	}

	@Test
	void registrationWorksThroughAllLayers() throws Exception {

		// UserResource user = new UserResource("Zaphod", "zaphod@galaxy.net");
		//
		// mockMvc.perform(post("/forums/{forumId}/register", 42L)
		// .contentType("application/json")
		// .param("sendWelcomeMail", "true")
		// .content(objectMapper.writeValueAsString(user)))
		// .andExpect(status().isOk());
		//
		// UserEntity userEntity = userRepository.findByName("Zaphod");
		// assertThat(userEntity.getEmail()).isEqualTo("zaphod@galaxy.net");
	}

	@Test
	void testRegister() {
		// given

		// User user = new User("Zaphod", "zaphod@galaxy.net");
		// boolean sendWelcomeMail = true;
		// given(userRepository.save(any(UserEntity.class))).willReturn(userEntity(1L));
		//
		// // when
		// Long userId = registerUseCase.registerUser(user, sendWelcomeMail);

		// then
		// assertThat(userId).isEqualTo(1L);
	}
}