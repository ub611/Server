package com.example.petMate.service;

import java.io.IOException;
import java.util.List;

import com.example.petMate.command.ItemCommand;
import com.example.petMate.command.MyPageAdoptCommand;
import com.example.petMate.command.MyPageBuyCommand;
import com.example.petMate.command.MyPageItemCommand;
import com.example.petMate.command.MyPagePetCommand;
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
	
	List<MyPageItemCommand> getItem(String u_idx);
	
	List<MyPageBuyCommand> getBuyIamBuyer(String u_idx);

	List<MyPageAdoptCommand> getIamAdopter(String u_idx);
	
	List<MyPagePetCommand> getPet(String u_idx);


	// Item 
	List<Item> getItemList(int sort);// throws DataAccessException;

	Item getItemByItemIdx(int itemIdx);// throws DataAccessException;

	Item getItemByItemTitle(String itemTitle);// throws DataAccessException;

	void updateItem(Item itemIdx, Item Item);// throws DataAccessException;

	List<String> getItemnameList(); // throws DataAccessException;
	
	int createItem(ItemCommand itemCommand) throws IOException; //throws DataAccessException;

}
