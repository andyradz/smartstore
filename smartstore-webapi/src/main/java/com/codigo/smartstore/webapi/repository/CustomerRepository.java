package com.codigo.smartstore.webapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codigo.smartstore.webapi.domain.Customer;

@Repository
@NoRepositoryBean
public interface CustomerRepository
	extends PagingAndSortingRepository<Customer, Long> {

	// @RestResource(path = "name", rel="name")
	@Override
	@Query("select c from Customers c")
	Page<Customer> findAll(Pageable pageable);

	@Override
	@Query("select c from Customers c")
	List<Customer> findAll(Sort sort);

}