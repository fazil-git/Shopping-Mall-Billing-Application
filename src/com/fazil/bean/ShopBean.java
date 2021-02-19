package com.fazil.bean;

import java.util.List;
import java.util.Set;

import com.fazil.dao.ShopDAO;
import com.fazil.dao.ShopDAOImpl;
import com.fazil.dto.Item;
import com.fazil.dto.Shop;

public class ShopBean {
	private List<Shop> shops;
	private Set<Item> items;

	public final List<Shop> getShops() {
		ShopDAO shopDAO=ShopDAOImpl.createShopDAO();
		shops=shopDAO.getAllShops();
		return shops;
	}

	public final void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	public final Set<Item> getItems() {
		return items;
	}

	public final void setItems(Set<Item> items) {
		this.items = items;
	}
}
