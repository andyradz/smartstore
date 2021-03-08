package com.codigo.smartstore.webapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.codigo.smartstore.webapi.domain.Employee;
import com.codigo.smartstore.webapi.repository.EmployeeRepository;

@Configuration
public class TestBean {

	@Bean
	public EmployeeRepository developerService() {

		return new EmployeeRepository() {

			@Override
			public <S extends Employee> S save(final S entity) {

				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <S extends Employee> Iterable<S> saveAll(final Iterable<S> entities) {

				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Optional<Employee> findById(final Long id) {

				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean existsById(final Long id) {

				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterable<Employee> findAll() {

				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Iterable<Employee> findAllById(final Iterable<Long> ids) {

				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long count() {

				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void deleteById(final Long id) {

				// TODO Auto-generated method stub

			}

			@Override
			public void delete(final Employee entity) {

				// TODO Auto-generated method stub

			}

			@Override
			public void deleteAll(final Iterable<? extends Employee> entities) {

				// TODO Auto-generated method stub

			}

			@Override
			public void deleteAll() {

				// TODO Auto-generated method stub

			}

			@Override
			public Page<Employee> findAll(final Pageable pageable) {

				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Employee> findAll(final Sort sort) {

				// TODO Auto-generated method stub
				return null;
			}
		};
	}
}