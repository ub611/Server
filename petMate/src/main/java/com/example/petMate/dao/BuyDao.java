package com.example.petMate.dao;

import org.springframework.dao.DataAccessException;

import com.example.petMate.domain.Item;
import com.example.petMate.domain.buy;

public interface BuyDao {

	 buy getBuy(int orderId) throws DataAccessException;

	 void insertBuy(Item item, buy buy) throws DataAccessException;

}
