package com.example.petMate.dao;

import java.util.List;

import com.example.petMate.domain.Account;

public interface AccountDao {

	  Account getAccount(String username);// throws DataAccessException;

	  Account getAccount(String username, String password);// throws DataAccessException;

	  void insertAccount(Account account);// throws DataAccessException;

	  void updateAccount(Account account);// throws DataAccessException;
	  
	  List<String> getUsernameList(); // throws DataAccessException;
	  
}