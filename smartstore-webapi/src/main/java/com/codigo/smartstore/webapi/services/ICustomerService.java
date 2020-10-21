package com.codigo.smartstore.webapi.services;

import java.util.Optional;

import com.codigo.smartstore.webapi.domain.Customer;

public interface ICustomerService {

	Customer createCustomer(Customer customer);

	Optional<Customer> findCustomer(Long id);

	void updateCustomer(Customer customer);
}
