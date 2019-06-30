package com.example.petMate.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.petMate.domain.Item;
import com.example.petMate.domain.LineItem;
import com.example.petMate.domain.buy;

public interface BuyMapper {
	@Select("SELECT * "
			+ "FROM buy "
			+ "WHERE b_idx=#{b_idx}")
	buy getBuy(@Param("b_idx")int b_idx);
	
	@Insert("INSERT INTO buy "
			+ "VALUES(null, #{buy.b_date}, #{item.i_price}, "
			+ "#{buy.b_state}, #{item.user_u_idx}, #{buy.buyer_idx}, #{item.i_idx})")
	void insertBuy(@Param("item")Item item, @Param("buy")buy buy);
}
