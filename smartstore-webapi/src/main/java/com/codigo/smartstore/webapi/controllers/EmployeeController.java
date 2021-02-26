package com.codigo.smartstore.webapi.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.codigo.smartstore.webapi.domain.Employee;
import com.codigo.smartstore.webapi.dto.EmployeeAdd;
import com.codigo.smartstore.webapi.services.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// https://www.baeldung.com/spring-mvc-custom-validator

@RestController
@RequestMapping("${api.endpoint.accounting}")
@Api(value = "${api.endpoint.accounting}")
@Validated
public class EmployeeController {

	private static Logger log = LoggerFactory.getLogger(EmployeeController.class);

	private final List<Employee> data = List.of(new Employee(1L, "Andrzej", "Połaniecki", "Admin"),
		new Employee(2L, "Andrzej1", "Połaniecki1", "Admin1"),
		new Employee(3L, "Izabela", "Radziszewska", "Moderator"),
		new Employee(4L, "Aleksandra", "Radziszewska", "Student"),
		new Employee(5L, "Bartosz", "Kawecki", "Poseł"));

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

	@ApiOperation(
		value = "Fetch all employees",
		notes = "provide full list about employees test",
		response = List.class)
	@ApiResponses(
		value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list extra", response = Employee.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(path = "/employees", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PDF_VALUE })
	@ResponseBody
	public ResponseEntity<List<Employee>> fetchAllEmployees() throws Exception {

		return ResponseEntity.ok(
			this.data
		);
	}

	@GetMapping(path = "/employees/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Employee> fetchEmployeeById(@ApiParam(
		value = "unique id of employee",
		example = "123") @PathVariable("id") @Min(1) @Max(Long.MAX_VALUE) final Long employeeId) {

		final var employeeOptional = this.data.stream()
				.filter(employee -> employeeId.equals(employee.getId()))
				.findFirst();

		if (employeeOptional.isEmpty())
			return ResponseEntity.notFound()
					.build();

		final HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "employee");

		return ResponseEntity.ok(employeeOptional.get());
	}

	@PostMapping("/employees")
	public ResponseEntity<Long> insertEmployee(
			@RequestBody @Valid @ModelAttribute("employee") final EmployeeAdd employee, final BindingResult result,
			final Model model) {

		if (result.hasErrors())
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.build();

		model.addAttribute("name", employee.getFirstName());
		model.addAttribute("lastName", employee.getLastName());

		return ResponseEntity.ok()
				.build();
	}

	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<Long> deleteEmployee(@PathVariable @Min(1) @Max(Long.MAX_VALUE) final Long employeeId) {

		final var employeeOptional = this.data.stream()
				.filter(employee -> employeeId.equals(employee.getId()))
				.findFirst();

		return employeeOptional.isEmpty()
				? ResponseEntity.notFound()
						.build()
					: ResponseEntity.ok()
							.build();
	}

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
	@ResponseBody
	// @Async
	public DeferredResult<String> handleReqDefResult(final Model model) {

		final DeferredResult<String> deferredResult = new DeferredResult<>();

		new Thread((
		) -> {

			try {

				Thread.sleep(2000);
			} catch (final InterruptedException e) {

				e.printStackTrace();
			}
			deferredResult.setResult("test async result");
		}).start();

		return deferredResult;
	}
}