package com.codigo.smartstore.webapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codigo.smartstore.webapi.domain.Customer;

@Repository
// @NoRepositoryBean
public interface CustomerRepository
	extends PagingAndSortingRepository<Customer, Long> {

	// @RestResource(path = "name", rel="name")
	@Query("select c from Employee c")
	Page<Customer> findAllPage(Pageable pageable);

	// @Query("select c from MovieCharacter c")
	// Slice<Employee> findAllSlice(Pageable pageable);

	@Query("select c from Customer c")
	List<Customer> findAllSorted(Sort sort);

	// Page<Employee> findByMovie(String movieName, Pageable pageable);

	// @Query("select c from MovieCharacter c where c.movie = :movie")
	// Slice<Employee> findByMovieCustom(@Param("movie") String movieName, Pageable
	// pageable);

	// @Query("select c from MovieCharacter c where c.movie = :movie")
	// List<Employee> findByMovieSorted(@Param("movie") String movieName, Sort
	// sort);
}