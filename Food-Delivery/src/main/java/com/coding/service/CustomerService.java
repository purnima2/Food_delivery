package com.coding.service;

import com.coding.model.Customer;

public interface CustomerService {
	public Customer createCustomer(Customer cust);

	public Customer readCustomer(Long id);


}
