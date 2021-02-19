package com.fazil.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shopId;
	private String shopName;
	@OneToMany(mappedBy = "shop")
	private Set<Item> items=new HashSet<Item>();
	
	public final int getShopId() {
		return shopId;
	}
	public final void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public final String getShopName() {
		return shopName;
	}
	public final void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public final Set<Item> getItems() {
		return items;
	}
	public final void setItems(Set<Item> items) {
		this.items = items;
	}
	
}
