package com.fazil.Hibernate50;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fazil.dto.Customer;
import com.fazil.dto.Invoice;
import com.fazil.utility.HibernateUtility;

public class Test1 {
    public static void main( String[] args ){
    	try {
    		Session session=HibernateUtility.getSession();
    		
	    	Invoice invoice1=new Invoice();
	    	
	    	Query query=session.createQuery("from Customer where customerId=:c");
	    	query.setParameter("c", 1005);
	    	
	    	Customer customer1=(Customer) query.uniqueResult();
	    	//customer1.setCustomerId(1001);	not required, it gets from db and builds customer obj
	    	
	    	invoice1.setBillDate(new Date());
	    	invoice1.setCustomer(customer1);
	    
	    	System.out.println("syso: "+customer1);
	    	session.save(invoice1);
	    	HibernateUtility.closeSession(null);
	    	
    	}catch(Exception e) {
    		e.printStackTrace();
    		HibernateUtility.closeSession(e);
    	}
    	
    }
}
