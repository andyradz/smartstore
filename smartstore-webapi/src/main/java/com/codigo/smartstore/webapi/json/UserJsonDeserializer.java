package com.codigo.smartstore.webapi.json;

import java.awt.Color;
import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.codigo.smartstore.webapi.domain.Employee;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

@JsonComponent
public class UserJsonDeserializer
		extends
		JsonDeserializer<Employee> {

	@Override
	public Employee deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {

		final TreeNode treeNode = jsonParser.getCodec()
				.readTree(jsonParser);
		final TextNode favoriteColor = (TextNode) treeNode.get("favoriteColor");
		return new Employee();				
	}

	// @Override
	// public Employee deserialize(final JsonParser p, final DeserializationContext
	// ctxt)
	// throws IOException, JsonProcessingException {
	//
	// return null;
	// }
}
