package com.codigo.smartstore;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codigo.smartstore.webapi.domain.Customer;
import com.codigo.smartstore.webapi.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerRestController {

	private final CustomerService customerService;
	// private final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	public CustomerRestController(final CustomerService customerService) {

		this.customerService = customerService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> createCustomer(@RequestBody final Customer customer) {

		final Customer customerCreated = this.customerService.createCustomer(customer);

		final URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(customerCreated.getId())
				.toUri();

		return ResponseEntity.created(location)
				.build();
	}

	// @PatchMapping(
	// path = "/{id}",
	// consumes = "application/json-patch+json")
	// public ResponseEntity<Customer> updateCustomer(@PathVariable final String id,
	// @RequestBody final JsonPatch patch) {
	// try {
	// final Customer customer = this.customerService.findCustomer(id)
	// .orElseThrow(CustomerNotFoundException::new);
	// final Customer customerPatched = this.applyPatchToCustomer(patch, customer);
	// this.customerService.updateCustomer(customerPatched);
	// return ResponseEntity.ok(customerPatched);
	// } catch (final CustomerNotFoundException e) {
	// return ResponseEntity.status(HttpStatus.NOT_FOUND)
	// .build();
	// } catch (JsonPatchException | JsonProcessingException e) {
	// return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	// .build();
	// }
	// }
	//
	// private Customer applyPatchToCustomer(final JsonPath patch, final Customer
	// targetCustomer)
	// throws JsonPatchException, JsonProcessingException {
	//
	// final JsonNode patched =
	// patch.apply(this.objectMapper.convertValue(targetCustomer, JsonNode.class));
	// return this.objectMapper.treeToValue(patched, Customer.class);
	// }
}
