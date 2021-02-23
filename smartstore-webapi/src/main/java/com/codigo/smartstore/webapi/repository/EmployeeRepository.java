package com.codigo.smartstore.webapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codigo.smartstore.webapi.domain.Employee;

@Repository
@NoRepositoryBean
public interface EmployeeRepository
	extends PagingAndSortingRepository<Employee, Long> {

	// @RestResource(path = "name", rel="name")
	@Override
	@Query("select e from employees e")
	Page<Employee> findAll(Pageable pageable);

	// @Query("select c from MovieCharacter c")
	// Slice<Employee> findAllSlice(Pageable pageable);

	@Override
	@Query("select e from employees e")
	List<Employee> findAll(Sort sort);

	// @Override
	// @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.phones")
	// List<Employee> findAll1();

	// Page<Employee> findByMovie(String movieName, Pageable pageable);

	// @Query("select c from MovieCharacter c where c.movie = :movie")
	// Slice<Employee> findByMovieCustom(@Param("movie") String movieName, Pageable
	// pageable);

	// @Query("select c from MovieCharacter c where c.movie = :movie")
	// List<Employee> findByMovieSorted(@Param("movie") String movieName, Sort
	// sort);
}

// curl -v
// http://localhost:8080/people/search/nameStartsWith?name=K&sort=name&name.dir=desc
