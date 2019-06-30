package com.example.petMate.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.petMate.dao.BuyDao;
import com.example.petMate.dao.mybatis.mapper.BuyMapper;
import com.example.petMate.domain.Item;
import com.example.petMate.domain.LineItem;
import com.example.petMate.domain.buy;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisBuyDao implements BuyDao {
	
	@Autowired
	protected BuyMapper buyMapper;

	
	@Transactional
	public buy getBuy(int b_idx) throws DataAccessException {
		buy buy = buyMapper.getBuy(b_idx);
	    return buy;
	}
	
	@Transactional
	public void insertBuy(Item item, buy buy) throws DataAccessException {  
    	buyMapper.insertBuy(item, buy);
	}
}
