package com.example.petMate.dao;

import java.util.List;
import com.example.petMate.domain.Item;

public interface ItemDao {

	  List<Item> getItemList();// throws DataAccessException;

	  Item getItemByItemIdx(int itemIdx);// throws DataAccessException;

	  Item getItemByItemTitle(String itemTitle);// throws DataAccessException;

	  void updateItem(Item itemIdx, Item Item);// throws DataAccessException;
	  
	  List<String> getItemnameList(); // throws DataAccessException;
}
