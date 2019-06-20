package com.example.petMate.service;

import java.io.IOException;
import java.util.List;

import com.example.petMate.command.ItemCommand;
import com.example.petMate.domain.Account;
import com.example.petMate.domain.Adopt;
import com.example.petMate.domain.Item;
import com.example.petMate.domain.Pet;
import com.example.petMate.domain.buy;

public interface PetMateFacade {
	// User
	Account getAccount(String username, String password);// throws DataAccessException;
	
	Account getAccountById(String username);

	void insertAccount(Account account);// throws DataAccessException;

	void updateAccount(Account account);// throws DataAccessException;
	
//	Item getItem(String u_idx);
//	
//	buy getBuyIamBuyer(String u_idx);
//
//	Pet getIamAdopter(String u_idx);
//	
//	Adopt getPet(String u_idx);



	// Item 
	List<Item> getItemList(int sort);// throws DataAccessException;

	Item getItemByItemIdx(int itemIdx);// throws DataAccessException;

	Item getItemByItemTitle(String itemTitle);// throws DataAccessException;

	int updateItem(ItemCommand Item) throws IOException;// throws DataAccessException;

	List<String> getItemnameList(); // throws DataAccessException;
	
	int createItem(ItemCommand itemCommand) throws IOException; //throws DataAccessException;
	
	int deleteItem(int i_idx) throws IOException; //throws DataAccessException;

}
