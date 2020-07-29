/** Class to Insert  Customer data in  database 
 *and Read  Customer data from  database 
 * */

package com.coding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coding.model.Customer;
import com.coding.repository.CustomerRepository;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository cusomerrepositoty;

	/**Method to insert data in Entity/database
	 * */
	@Override
	public Customer createCustomer(Customer cust) {
		if (cust != null) {
			return cusomerrepositoty.save(cust);
		}
		return null;
	}

	
	/**Method to retrieve data from database 
	 * */
	@Override
	public Customer readCustomer(Long id) {
		if (id != null) {
			Customer cust = cusomerrepositoty.findOne(id);
			if (cust != null)
				return cust;
		}
		return null;
	}

}
