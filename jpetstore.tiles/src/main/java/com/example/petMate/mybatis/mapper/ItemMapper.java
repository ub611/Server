package com.example.petMate.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.example.petMate.domain.Item;

public interface ItemMapper {

	  List<Item> getItemList();// throws DataAccessException;

	  Item getItemByItemIdx(int itemIdx);// throws DataAccessException;

	  Item getItemByItemTitle(String itemTitle);// throws DataAccessException;

	  void updateItem(Item itemIdx, Item Item);// throws DataAccessException;
	  
	  List<String> getItemnameList(); // throws DataAccessException;

}
