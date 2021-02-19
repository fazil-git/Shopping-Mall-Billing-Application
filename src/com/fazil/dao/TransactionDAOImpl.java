package com.fazil.dao;

import java.util.Set;

import org.hibernate.Session;

import com.fazil.dto.Invoice;
import com.fazil.dto.Item;
import com.fazil.dto.Transaction;
import com.fazil.utility.HibernateUtility;

public class TransactionDAOImpl implements TransactionDAO {
	private static TransactionDAOImpl obj;
	private TransactionDAOImpl() {
		
	}
	public static TransactionDAOImpl createTransactionDAO() {
		if(obj==null) obj=new TransactionDAOImpl();
		return obj;
	}
	@Override
	public void setTransaction(Invoice invoice, Set<Item> items) {
		try {
			Session session=HibernateUtility.getSession();
			session.save(invoice);
			for(Item item:items) {
				Transaction trx=new Transaction();
				trx.setInvoice(invoice);
				trx.setItem(item);
				trx.setQty(1);
				
				invoice.getTrx().add(trx);	//adding all the trx in invoice hashset
				item.getTrx().add(trx);		//adding all the trx in item hashset
				
				session.save(trx);
			}
			HibernateUtility.closeSession(null);
		}catch(Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
	}
}

//Note: we are not saving item; since we don't want item table to be updated. We just want to use the itemtable