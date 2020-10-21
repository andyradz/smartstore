package com.codigo.smartstore.webapi.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codigo.smartstore.webapi.domain.Book;
import com.codigo.smartstore.webapi.repository.BookRepository;

@RestController
public class BookController {

	@Inject
	private BookRepository repository;

	@GetMapping("${api.endpoint.accounting}" + "/books")
	@ResponseBody
	public ResponseEntity<List<Book>> all() {

		return new ResponseEntity<>(StreamSupport.stream(this.repository.findAll()
				.spliterator(),
			false)
				.collect(Collectors.toList()), HttpStatus.OK);
	}

	/**
	 * Metoda REST API zwraca dane pozycji ksiązki o wskazanym id
	 *
	 * @param id Identyfikator pozycji ksiązki khjhk jhkhkj hkjhkj kjhkj kjh
	 * khkhkkhkh k h
	 *
	 * @return
	 */
	@GetMapping("${api.endpoint.accounting}" + "/books/{id}")
	public ResponseEntity<Book> one(@PathVariable(required = true) @Min(1) @Max(10) final String id) {

		final var book = this.repository.findById(id);

		return book.isEmpty()
				? ResponseEntity.noContent()
						.build()
					: ResponseEntity.ok(book.get());
	}
}