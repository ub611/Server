package com.example.petMate.service;

import java.io.IOException;
import java.util.List;

import com.example.petMate.command.ItemCommand;
import com.example.petMate.domain.Account;
import com.example.petMate.domain.Item;

public interface PetMateFacade {

	// User
	Account getAccount(String username);// throws DataAccessException;

	Account getAccount(String username, String password);// throws DataAccessException;

	void insertAccount(Account account);// throws DataAccessException;

	void updateAccount(Account account);// throws DataAccessException;

	List<String> getUsernameList(); // throws DataAccessException;


	// Item 
	List<Item> getItemList(int sort);// throws DataAccessException;

	Item getItemByItemIdx(int itemIdx);// throws DataAccessException;

	Item getItemByItemTitle(String itemTitle);// throws DataAccessException;

	void updateItem(Item itemIdx, Item Item);// throws DataAccessException;

	List<String> getItemnameList(); // throws DataAccessException;
	
	int createItem(ItemCommand itemCommand) throws IOException; //throws DataAccessException;

}
