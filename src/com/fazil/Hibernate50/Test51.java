package com.fazil.Hibernate50;

import java.util.HashSet;
import java.util.Set;

public class Test51 {
	public static void main(String[] args) {
		//InvoiceBusiness shoppingBusiness=new InvoiceBusiness();
		Set<Integer> itemIds=new HashSet<Integer>();
		itemIds.add(2);
		itemIds.add(3);
		//shoppingBusiness.placeOrder(customerId, itemIds);	//i changed it to receive Customer direcly from httpsession obj
	}
}
