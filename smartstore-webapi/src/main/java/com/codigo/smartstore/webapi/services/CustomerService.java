package com.codigo.smartstore.webapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codigo.smartstore.webapi.domain.Customer;

@Service
public class CustomerService
	implements ICustomerService {

	@Inject
	private final ICustomerIdGenerator customerIdGenerator;
	private final List<Customer> customers = new ArrayList<>();

	@Autowired
	public CustomerService(final ICustomerIdGenerator customerIdGenerator) {

		this.customerIdGenerator = customerIdGenerator;
	}

	@Override
	public Customer createCustomer(final Customer customer) {

		customer.setId(this.customerIdGenerator.generateNextId());
		this.customers.add(customer);
		return customer;
	}

	@Override
	public Optional<Customer> findCustomer(final Long id) {

		return this.customers.stream()
				.filter(
					customer -> customer.getId()
							.equals(id))
				.findFirst();
	}

	@Override
	public void updateCustomer(final Customer customer) {

		this.customers.set(this.customers.indexOf(customer), customer);
	}
}
