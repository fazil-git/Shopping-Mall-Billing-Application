package com.fazil.business;

import java.util.Set;

import com.fazil.dao.ItemDAO;
import com.fazil.dao.ItemDAOImpl;
import com.fazil.dao.TransactionDAO;
import com.fazil.dao.TransactionDAOImpl;
import com.fazil.dto.Customer;
import com.fazil.dto.Invoice;
import com.fazil.dto.Item;

public class InvoiceBusiness {
	
	public Invoice placeOrder(Customer customer, Set<Integer> itemIds) {
		
		ItemDAO itemDAO=ItemDAOImpl.createItemDAO();
		Set<Item> items=itemDAO.getItems(itemIds);
		
		GenInvoiceBusiness genInvoice=new GenInvoiceBusiness();
		Invoice invoice=genInvoice.setInvoice(customer);
		
		TransactionDAO trxDAO=TransactionDAOImpl.createTransactionDAO();
		trxDAO.setTransaction(invoice, items);
		
		return invoice;
	}
	
	public void generateInvoice(){
		
	}
}
