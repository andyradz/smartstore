package com.codigo.smartstore.webapi.controllers;

// @RestController
// @RequestMapping(value = "/customers")
// public class CustomerRestController {
// private CustomerService customerService;
// private ObjectMapper objectMapper = new ObjectMapper();
//
// @Autowired
// public CustomerRestController(CustomerService customerService) {
// this.customerService = customerService;
// }
//
// @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
// public ResponseEntity<Customer> createCustomer(@RequestBody Customer
// customer) {
// Customer customerCreated = customerService.createCustomer(customer);
// URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
// .buildAndExpand(customerCreated.getId()).toUri();
//
// return ResponseEntity.created(location).build();
// }
//
//
//
// @Autowired private EntityLinks links;
//
// @GetMapping(value = "/products",produces =MediaType.APPLICATION_JSON_VALUE)
// public ResponseEntity<PagedResources<Employee>> AllProducts(Pageable
// pageable, PagedResourcesAssembler assembler){
// Page<Employee> products = productService.findAllProducts(pageable);
// PagedResources<Employee> pr=
// assembler.toResource(products,linkTo(CustomerRestController.class).slash("/products").withSelfRel());
// HttpHeaders responseHeaders = new HttpHeaders();
// responseHeaders.add("Link",createLinkHeader(pr));
// return new
// ResponseEntity<>(assembler.toResource(products,linkTo(CustomerRestController.class).slash("/products").withSelfRel()),responseHeaders,HttpStatus.OK);
// }
//
// private String createLinkHeader(PagedResources<Employee> pr){
// final StringBuilder linkHeader = new StringBuilder();
// linkHeader.append(buildLinkHeader(
// pr.getLinks("first").get(0).getHref(),"first"));
// linkHeader.append(", ");
// linkHeader.append(buildLinkHeader(
// pr.getLinks("next").get(0).getHref(),"next"));
// return linkHeader.toString();
// }
//
// public static String buildLinkHeader(final String uri, final String rel) {
// return "<" + uri + ">; rel=\"" + rel + "\"";
// }

// @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
// public ResponseEntity<Customer> updateCustomer(@PathVariable String id,
// @RequestBody JsonPatch patch) {
// try {
// Customer customer =
// customerService.findCustomer(id).orElseThrow(CustomerNotFoundException::new);
// Customer customerPatched = applyPatchToCustomer(patch, customer);
// customerService.updateCustomer(customerPatched);
//
// return ResponseEntity.ok(customerPatched);
// } catch (CustomerNotFoundException e) {
// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
// } catch (JsonPatchException | JsonProcessingException e) {
// return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
// }
// }
//
// private Customer applyPatchToCustomer(JsonPatch patch, Customer
// targetCustomer)
// throws JsonPatchException, JsonProcessingException {
// JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer,
// JsonNode.class));
// return objectMapper.treeToValue(patched, Customer.class);
// }
// }