package com.fazil.Hibernate50;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.fazil.dto.Item;
import com.fazil.dto.Shop;
import com.fazil.utility.HibernateUtility;

public class Test4 {
	public static void main(String[] args) {
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Shop.class);
		List<Shop> shops=criteria.list();
		for(Shop shop:shops) {
			System.out.println("shop name: "+shop.getShopName());
			Set<Item> items=shop.getItems();
			for(Item item:items) {
				System.out.println("\titem name:"+item.getItemdescription());
			}
		}
	}
}
