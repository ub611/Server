package com.example.petMate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.petMate.domain.Account;


public interface AccountDao {
	  void insertAccount(Account account);// throws DataAccessException;
}