package com.codigo.smartstore.webapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codigo.smartstore.webapi.domain.Employee;
import com.codigo.smartstore.webapi.repository.EmployeeRepository;

@RestController
// @RequiredArgsConstructor
public class PagedController {

	@Autowired
	private EmployeeRepository employeeRepository;

	public PagedController() {

	}

	@GetMapping(
		path = "/characters/page",
		produces = "application/json")
	public Page<Employee> loadCharactersPage(@PageableDefault(
		page = 0,
		size = 20) @SortDefault.SortDefaults({
			@SortDefault(
				sort = "lastName",
				direction = Sort.Direction.DESC),
			@SortDefault(
				sort = "id",
				direction = Sort.Direction.ASC) }) final Pageable pageable) {

		return this.employeeRepository.findAllPage(pageable);
	}

	@GetMapping(
		path = "/characters/qualifier",
		produces = "application/json")
	public Page<Employee> loadCharactersPageWithQualifier(@Qualifier("my") final Pageable pageable) {

		return this.employeeRepository.findAllPage(pageable);
	}

	@GetMapping(
		path = "/characters/sorted",
		produces = "application/json")
	public List<Employee> loadCharactersSorted(final Sort sort) {

		return this.employeeRepository.findAll(sort);
	}

	// @GetMapping(path = "/characters/slice")
	// Slice<Employee> loadCharactersSlice(Pageable pageable) {
	//
	// return employeeRepository.findAllSlice(pageable);
	// }
}