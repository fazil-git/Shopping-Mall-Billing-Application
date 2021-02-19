package com.fazil.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	private String itemdescription;
	private String unit;
	private int price;
	private String img;
	@ManyToOne
	@JoinColumn(name = "shopId")
	private Shop shop;
	
	@OneToMany(mappedBy = "item")
	private Set<Transaction> trx=new HashSet<Transaction>(0);
	
	public final Set<Transaction> getTrx() {
		return trx;
	}
	public final void setTrx(Set<Transaction> trx) {
		this.trx = trx;
	}
	public final int getItemId() {
		return itemId;
	}
	public final void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public final String getItemdescription() {
		return itemdescription;
	}
	public final void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}
	public final String getUnit() {
		return unit;
	}
	public final void setUnit(String unit) {
		this.unit = unit;
	}
	public final int getPrice() {
		return price;
	}
	public final void setPrice(int price) {
		this.price = price;
	}
	public final String getImg() {
		return img;
	}
	public final void setImg(String img) {
		this.img = img;
	}
	public final Shop getShop() {
		return shop;
	}
	public final void setShop(Shop shop) {
		this.shop = shop;
	}
	
}
