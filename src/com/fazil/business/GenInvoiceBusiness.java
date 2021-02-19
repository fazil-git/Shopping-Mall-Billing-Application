package com.fazil.business;

import java.util.Date;

import com.fazil.dto.Customer;
import com.fazil.dto.Invoice;

public class GenInvoiceBusiness {
	
	public Invoice setInvoice(Customer customer) {

		Invoice invoice=new Invoice();
		invoice.setBillDate(new Date());
		invoice.setCustomer(customer);
		invoice.setDiscount(0);
		invoice.setGst(0);
		
		return invoice;
	}
}
