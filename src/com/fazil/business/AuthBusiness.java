package com.fazil.business;

import com.fazil.dao.CustomerDAO;
import com.fazil.dao.CustomerDAOImpl;
import com.fazil.dto.Customer;

public class AuthBusiness {
	public Customer verifyCustomer(int customerId) {
		CustomerDAO customerDAO=CustomerDAOImpl.createCustomerDAO();
		Customer customer=customerDAO.getCustomer(customerId);	//got existing customer
		return customer;
	}
}
