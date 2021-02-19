package com.fazil.Hibernate50;

import org.hibernate.Session;

import com.fazil.dto.Item;
import com.fazil.utility.HibernateUtility;

public class Test2 {
	public static void main(String[] args) {
		try {
			Session session=HibernateUtility.getSession();
			
			Item item1=new Item();
			item1.setItemdescription("iphone");
			item1.setUnit("Pcs");
			item1.setPrice(60000);
			item1.setImg("something..");
			
			session.save(item1);
			HibernateUtility.closeSession(null);
			
		}catch(Exception e) {
			e.printStackTrace();
			HibernateUtility.closeSession(e);
		}
	}
}
