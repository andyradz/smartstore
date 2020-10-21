package com.codigo.smartstore.webapi.services;

import java.util.Random;

public class CustomerIdGenerator
	implements ICustomerIdGenerator {

	@Override
	public long generateNextId() {

		// create instance of Random class
		final Random rand = new Random();

		// Generate random integers in range 0 to 999
		final long rand1 = rand.nextInt(10_000);

		return rand1;
	}
}
