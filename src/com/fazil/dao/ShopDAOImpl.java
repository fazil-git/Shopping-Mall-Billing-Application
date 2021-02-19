package com.fazil.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fazil.dto.Shop;
import com.fazil.utility.HibernateUtility;

public class ShopDAOImpl implements ShopDAO{
	private static ShopDAOImpl obj;
	private ShopDAOImpl() {
		
	}
	public static ShopDAOImpl createShopDAO() {
		if(obj==null) obj=new ShopDAOImpl();
		return obj;
	}
	
	public List<Shop> getAllShops() {
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Shop.class);
		List<Shop> shops=criteria.list();
		for(Shop shop:shops) {
			System.out.println("Shop name: "+shop.getShopName());
			//System.out.println("Shop to string: "+shop);
		}
		return shops;
	}
}
