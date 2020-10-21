package com.codigo.smartstore.webapi.json;

import java.awt.Color;
import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.codigo.smartstore.webapi.domain.Employee;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class UserJsonSerializer
		extends
		JsonSerializer<Employee> {

	@Override
	public void serialize(final Employee user, final JsonGenerator jsonGenerator,
			final SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("favoriteColor", user.getName());
		jsonGenerator.writeEndObject();
	}

	private static String getColorAsWebColor(final Color color) {

		final int r = (int) Math.round(color.getRed() * 255.0);
		final int g = (int) Math.round(color.getGreen() * 255.0);
		final int b = (int) Math.round(color.getBlue() * 255.0);
		return String.format("#%02x%02x%02x", r, g, b);
	}
}