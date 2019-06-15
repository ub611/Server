package com.example.petMate.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.example.petMate.domain.Item;

public interface ItemMapper {

	@Select({"SELECT * FROM ITEM ORDER BY "})
	List<Item> getItemList();

	Item getItemByItemIdx(int itemIdx);

	Item getItemByItemTitle(String itemTitle);

	void updateItem(Item itemIdx, Item Item);

	List<String> getItemnameList();
}
