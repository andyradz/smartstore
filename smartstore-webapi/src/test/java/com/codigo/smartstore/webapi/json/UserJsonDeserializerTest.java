package com.codigo.smartstore.webapi.json;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.codigo.smartstore.webapi.domain.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserJsonDeserializerTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testDeserialize() throws IOException {

		final String json = "{\"favoriteColor\":\"#f0f8ff\"}";
		this.objectMapper.readValue(json, Employee.class);

		// assertEquals(Color.ALICEBLUE, user.getFavoriteColor());
	}
}