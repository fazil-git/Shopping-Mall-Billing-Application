package com.fazil.dao;

import java.util.Set;

import com.fazil.dto.Item;

public interface ItemDAO {
	public Set<Item> getItems(Set<Integer> itemIds);
}
