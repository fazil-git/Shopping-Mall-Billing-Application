package com.fazil.Hibernate50;

import org.hibernate.Session;

import com.fazil.dto.Invoice;
import com.fazil.dto.Item;
import com.fazil.dto.Transaction;
import com.fazil.utility.HibernateUtility;

public class Test3 {
	public static void main(String[] args) {
		try {
			Session session=HibernateUtility.getSession();
			
			//invoiceId		itemId		Qty
			//4				1			30
			//4				2			20
			
			
			
			
			Invoice invoice1=new Invoice();
			
			
			Transaction trx1=new Transaction();			
			Item item1=new Item();
			item1.setItemId(1);
			item1.getTrx().add(trx1);		//done
			trx1.setInvoice(invoice1);		//done
			trx1.setItem(item1);
			trx1.setQty(100);
			
			Transaction trx2=new Transaction();
			Item item2=new Item();
			item2.setItemId(2);				//fetch from db--- no no not necessary
			item2.getTrx().add(trx2);
			trx2.setInvoice(invoice1);
			trx2.setItem(item2);			//done
			trx2.setQty(220);		
			
			
			
			invoice1.getTrx().add(trx1);	//done
			invoice1.getTrx().add(trx2);
			
			
			session.save(invoice1);
			session.save(trx1);
			session.save(trx2);
			
			HibernateUtility.closeSession(null);
			
		}catch(Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
		
	}
}
