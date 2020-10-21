package com.codigo.smartstore.webapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codigo.smartstore.webapi.domain.Book;

@Repository
public interface BookRepository
	extends PagingAndSortingRepository<Book, String> {

	@Query("select b from Book b")
	Page<Book> findAllPage(Pageable pageable);

}
