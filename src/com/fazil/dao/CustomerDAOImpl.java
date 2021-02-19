package com.fazil.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fazil.dto.Customer;
import com.fazil.utility.HibernateUtility;

public class CustomerDAOImpl implements CustomerDAO {
	private static CustomerDAOImpl obj;
	private CustomerDAOImpl() {
		
	}
	public static CustomerDAOImpl createCustomerDAO() {
		if(obj==null) obj=new CustomerDAOImpl();
		return obj;
	}
	
	public Customer getCustomer(int customerId) {

		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from Customer where customerId=:c");
		query.setParameter("c", customerId);
		
		Customer customer=(Customer) query.uniqueResult();
		customer.setCustomerId(customerId);
		return customer;	//if not found, it just set null.. no exeception will be thrown
	}
}
