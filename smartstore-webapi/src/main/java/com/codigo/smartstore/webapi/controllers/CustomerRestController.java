package com.codigo.smartstore.webapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerRestController {

	// private final CustomerService customerService;
	//
	// @Inject
	// public CustomerRestController(final CustomerService customerService) {
	//
	// this.customerService = customerService;
	// }
	//
	// @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<Customer> createCustomer(@RequestBody final Customer
	// customer) {
	//
	// final Customer customerCreated =
	// this.customerService.createCustomer(customer);
	// final URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	// .path("/{id}")
	// .buildAndExpand(customerCreated.getId())
	// .toUri();
	//
	// return ResponseEntity.created(location)
	// .build();
	// }

	// @Inject
	// private EntityLinks links;
	//
	// @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<PagedResources<Employee>> AllProducts(final Pageable
	// pageable,
	// final PagedResourcesAssembler assembler) {
	//
	// final Page<Employee> products = productService.findAllProducts(pageable);
	// final PagedResources<Employee> pr = assembler.toResource(products,
	// linkTo(CustomerRestController.class).slash("/products")
	// .withSelfRel());
	// final HttpHeaders responseHeaders = new HttpHeaders();
	// responseHeaders.add("Link", this.createLinkHeader(pr));
	// return new ResponseEntity<>(assembler.toResource(products,
	// linkTo(CustomerRestController.class).slash("/products")
	// .withSelfRel()),
	// responseHeaders, HttpStatus.OK);
	// }
	//
	// private String createLinkHeader(final PagedResources<Employee> pr) {
	//
	// final StringBuilder linkHeader = new StringBuilder();
	// linkHeader.append(buildLinkHeader(
	// pr.getLinks("first")
	// .get(0)
	// .getHref(),
	// "first"));
	// linkHeader.append(", ");
	// linkHeader.append(buildLinkHeader(
	// pr.getLinks("next")
	// .get(0)
	// .getHref(),
	// "next"));
	// return linkHeader.toString();
	// }
	//
	// public static String buildLinkHeader(final String uri, final String rel) {
	//
	// return "<" + uri
	// + ">; rel=\""
	// + rel
	// + "\"";
	// }
	//
	// @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
	// public ResponseEntity<Customer> updateCustomer(@PathVariable final String id,
	// @RequestBody final JsonPatch patch) {
	//
	// try {
	//
	// final Customer customer = this.customerService.findCustomer(id)
	// .orElseThrow(CustomerNotFoundException::new);
	// final Customer customerPatched = this.applyPatchToCustomer(patch, customer);
	// this.customerService.updateCustomer(customerPatched);
	//
	// return ResponseEntity.ok(customerPatched);
	// } catch (final CustomerNotFoundException e) {
	//
	// return ResponseEntity.status(HttpStatus.NOT_FOUND)
	// .build();
	// } catch (JsonPatchException | JsonProcessingException e) {
	//
	// return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	// .build();
	// }
	// }
	//
	// private Customer applyPatchToCustomer(final JsonPatch patch, final Customer
	// targetCustomer)
	// throws JsonPatchException, JsonProcessingException {
	//
	// final JsonNode patched =
	// patch.apply(this.objectMapper.convertValue(targetCustomer, JsonNode.class));
	// return this.objectMapper.treeToValue(patched, Customer.class);
	// }
}