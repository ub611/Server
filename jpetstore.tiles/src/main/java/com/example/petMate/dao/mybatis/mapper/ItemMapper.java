package com.example.petMate.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.petMate.domain.Item;

//@Mapper
public interface ItemMapper {

	@Select("SELECT * FROM item ORDER BY i_date")
	List<Item> getItemList();

	Item getItemByItemIdx(int itemIdx);

	Item getItemByItemTitle(String itemTitle);

	void updateItem(Item itemIdx, Item Item);

	List<String> getItemnameList();
}
