package com.example.petMate.dao;

import java.util.List;
import com.example.petMate.domain.Item;

public interface ItemDao {

	  List<Item> getAllItemList();// throws DataAccessException;
	  
	  List<Item> getItemListByCategory(int sort);// throws DataAccessException;

	  Item getItemByItemIdx(int item_idx);// throws DataAccessException;

	  Item getItemByItemTitle(String item_title);// throws DataAccessException;

	  void updateItem(Item item_idx, Item Item);// throws DataAccessException;
	  
	  List<String> getItemnameList(); // throws DataAccessException;
	  
	  String[] getItemImageUrls(int item_idx);
}
