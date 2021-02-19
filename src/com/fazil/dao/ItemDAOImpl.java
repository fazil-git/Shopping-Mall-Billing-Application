package com.fazil.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fazil.dto.Item;
import com.fazil.utility.HibernateUtility;

public class ItemDAOImpl implements ItemDAO{
	private static ItemDAOImpl obj;
	private ItemDAOImpl() {
		
	}
	public static ItemDAOImpl createItemDAO() {
		if(obj==null) obj=new ItemDAOImpl();
		return obj;
	}
	
	public Set<Item> getItems(Set<Integer> itemIds){
		Session session=HibernateUtility.getSession();
		Set<Item> items=new HashSet<Item>();
		for(Integer itemId:itemIds) {
			System.out.println("ItemIds = "+itemId);
			Query query=session.createQuery("from Item where itemId=:id");
			query.setParameter("id", itemId);
			Item item=(Item) query.uniqueResult();
			System.out.println("itemId: "+item.getItemId()+": item description"+item.getItemdescription());
			items.add(item);
		}
		return items;
	}
}
