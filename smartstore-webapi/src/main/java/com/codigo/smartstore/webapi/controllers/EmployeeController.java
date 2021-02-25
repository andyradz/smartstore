package com.codigo.smartstore.webapi.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.codigo.smartstore.webapi.domain.Employee;
import com.codigo.smartstore.webapi.services.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("${api.endpoint.accounting}")
@Api(value = "${api.endpoint.accounting}", description = "managing of employees")
// @Validated
public class EmployeeController {

	private static Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Inject
	private EmployeeService service;

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(final RuntimeException ex) {

		return new ResponseEntity<>(
				ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/employees/as")
	public void testAsynch() throws InterruptedException, ExecutionException {

		log.info("testAsynch Start");

		final CompletableFuture<Employee> employeeAddress = this.service.getEmployeeAddress();
		// final CompletableFuture<Employee> employeeName =
		// this.service.getEmployeeName();
		// final CompletableFuture<Employee> employeePhone =
		// this.service.getEmployeePhone();

		// Wait until they are all doneS
		CompletableFuture.allOf(employeeAddress)
				.join();

		log.info("EmployeeAddress--> " + employeeAddress.get());
		// log.info("EmployeeName--> " + employeeName.get());
		// log.info("EmployeePhone--> " + employeePhone.get());
	}

	// @GetMapping(
	// path = "${api.endpoint.accounting}" + "/employees/sort",
	// produces = { MediaType.APPLICATION_JSON_VALUE,
	// MediaType.APPLICATION_XML_VALUE })
	// @ResponseBody
	// public ResponseEntity<List<Employee>> loadCharactersSorted(final Sort sort) {
	//
	// return ResponseEntity.ok()
	// .body(this.repository.findAll(sort));
	// }
	//

	@ApiOperation(value = "Fetch all employees", notes = "provide full list about employees", response = List.class)
	@ApiResponses(
		value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list", response = Employee.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Failure") })
	@GetMapping(path = "/employees", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PDF_VALUE })
	@ResponseBody
	public ResponseEntity<List<Employee>> all() throws Exception {

		return ResponseEntity.ok(
			List.of(new Employee("Andrzej", "Połaniecki", "Admin"),
				new Employee("Andrzej1", "Połaniecki1", "Admin1"),
				new Employee("Izabela", "Radziszewska", "Moderator"),
				new Employee("Aleksandra", "Radziszewska", "Student"),
				new Employee("Bartosz", "Kawecki", "Poseł")
			));
	}

	@GetMapping(path = "/employees/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Employee> findById(
			@ApiParam(value = "unique id of employee", example = "123") @PathVariable final int id) {

		final HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "employee");

		return new ResponseEntity<>(new Employee("Andrzej", "Połaniecki", "Admin"), HttpStatus.OK);
	}
	//
	// @PostMapping("/employees")
	// public Employee newEmployee(@RequestBody final Employee employee) {
	//
	// return this.repository.save(employee);
	// }
	//
	// @PostMapping("${api.endpoint.accounting}" + "/employees")
	// public ResponseEntity<Employee> newEmployee1(@RequestBody final Employee
	// newEmployee) {
	// // location header
	// // HTTP 201 status code
	//
	// final var entity = this.repository.save(newEmployee);
	//
	// final URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	// .path("/{id}")
	// .buildAndExpand(entity.getId())
	// .toUri();
	//
	// return ResponseEntity.created(location)
	// .build();
	// }
	//
	// // Single item
	//
	// @GetMapping("${api.endpoint.accounting}" + "/employees/{id}")
	// public ResponseEntity<Employee> one(@PathVariable(required = true) @Min(1)
	// @Max(10) final Long id) {
	//
	// final var employee = this.repository.findById(id);
	//
	// if (employee.isEmpty())
	//
	// return ResponseEntity.noContent()
	// .build();
	// // employee.orElseGet(Employee::new);
	//
	// else
	// return ResponseEntity.ok(employee.get());
	// }
	//
	// @PutMapping("${api.endpoint.accounting}" + "/employees/{id}")
	// public Employee updateEmployee(@RequestBody final Employee newEmployee,
	// @PathVariable final Long id) {
	//
	// return this.repository.findById(id)
	// .map(employee -> {
	//
	// employee.setName(newEmployee.getName());
	// employee.setRole(newEmployee.getRole());
	// return this.repository.save(employee);
	// })
	// .orElseGet((
	// ) -> {
	//
	// newEmployee.setId(id);
	// return this.repository.save(newEmployee);
	// });
	// }
	//
	// @DeleteMapping("${api.endpoint.accounting}" + "/employees/{id}")
	// public void deleteEmployee(@PathVariable final Long id) {
	//
	// this.repository.deleteById(id);
	// }

	// @RequestMapping(value = "/callable", method = RequestMethod.GET)
	// public Callable<ResponseEntity<?>> timeCallable() {
	// // log.info("Callable time request");
	// return () -> ResponseEntity.ok(Instant.now());
	// }
	//
	// @RequestMapping(value = "/deferred", method = RequestMethod.GET)
	// public DeferredResult<ResponseEntity<?>> timeDeferred() {
	// // log.info("Deferred time request");
	// DeferredResult<ResponseEntity<?>> result = new DeferredResult<>();
	//
	// new Thread(() -> {
	// result.setResult(ResponseEntity.ok(Instant.now()));
	// }, "MyThread-").start();
	//
	// return result;
	// }
	//

	@GetMapping("${api.endpoint.accounting}" + "/employees/async")
	@Async
	public DeferredResult<ResponseEntity<?>> handleReqDefResult(final Model model) {

		final DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();

		ForkJoinPool.commonPool()
				.submit((
				) -> {

					try {

						Thread.sleep(6000);
					} catch (final InterruptedException e) {

					}
					output.setResult(ResponseEntity.ok("ok"));
				});
		return output;
	}
}

//// Step 1 - Without any options provided
// @RequestMapping(value="/{id}", method=RequestMethod.GET)
// public @ResponseBody Spittle spittleById(@PathVariable long id) {
// return spittleRepository.findOne(id);
// }
//
//// Step 2- We need to handle exception scenarios, as step 1 only caters happy
//// path.
// @ExceptionHandler(SpittleNotFoundException.class)
// @ResponseStatus(HttpStatus.NOT_FOUND)
// public Error spittleNotFound(SpittleNotFoundException e) {
// long spittleId = e.getSpittleId();
// return new Error(4, "Spittle [" + spittleId + "] not found");
// }
//
//// Step 3 - Now we will alter the service method, **if you want to provide
//// location**
// @RequestMapping(
// method=RequestMethod.POST
// consumes="application/json")
// public ResponseEntity<Spittle> saveSpittle(
// @RequestBody Spittle spittle,
// UriComponentsBuilder ucb) {
//
// Spittle spittle = spittleRepository.save(spittle);
// HttpHeaders headers = new HttpHeaders();
// URI locationUri =
// ucb.path("/spittles/")
// .path(String.valueOf(spittle.getId()))
// .build()
// .toUri();
// headers.setLocation(locationUri);
// ResponseEntity<Spittle> responseEntity =
// new ResponseEntity<Spittle>(
// spittle, headers, HttpStatus.CREATED)
// return responseEntity;
// }
//
//// Step4 - If you are not interested to provide the url location, you can omit
//// ResponseEntity and go with
// @RequestMapping(
// method=RequestMethod.POST
// consumes="application/json")
// @ResponseStatus(HttpStatus.CREATED)
// public Spittle saveSpittle(@RequestBody Spittle spittle) {
// return spittleRepository.save(spittle);
// }
