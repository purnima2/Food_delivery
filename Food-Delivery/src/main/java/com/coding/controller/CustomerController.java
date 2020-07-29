package com.coding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.model.Customer;
import com.coding.service.CustomerServiceImpl;
import com.coding.util.Utils;



@RestController
@RequestMapping(value = "/api")
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	Utils utils;

	
	
	/**Create operations for a customer using POST request 
	 * createCust() method is used
	 * */
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> createCust(@RequestBody Customer cust) {
		ResponseEntity<Customer> failed = new ResponseEntity<>(cust, HttpStatus.BAD_REQUEST);
		
		if (cust != null) {
			if (cust.getFirstName() != null && cust.getLastName() != null && cust.getId() != null
					&& cust.getPassword() != null && utils.validatePassword(
							cust.getPassword())  && utils.validateEmail(cust.getEmail()) ) {
				
				/**Validation for already existing customer_ID
				 * */
				if (customerServiceImpl.readCustomer(cust.getId()) == null) {
					Customer cus = customerServiceImpl.createCustomer(cust);

					if (cus != null) {
						return new ResponseEntity<>(cust, HttpStatus.CREATED);
					}
				}

			}
		}
		return failed;
	}

	
	
	
	/** Read operations to retrieved customer information - GET request
	 *  readCust() method is used
	 *  */
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> readCust(@PathVariable Long id) {
		ResponseEntity<Customer> failed = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		if (id != null) {
			Customer customer = customerServiceImpl.readCustomer(id);
			/**Validation for successful match of customer information
			 * */
			if (customer != null) {
				return new ResponseEntity<Customer>(customer, HttpStatus.OK);
			}
		}
		/**Validation for resource not found
		 * */
		return failed;
	}

}
