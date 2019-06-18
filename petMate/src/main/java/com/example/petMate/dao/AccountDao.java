package com.example.petMate.dao;


import org.springframework.dao.DataAccessException;
import com.example.petMate.domain.Account;

public interface AccountDao {

	//회원가입
	void insertAccount(Account account) throws DataAccessException;

	//회원정보 수정
	void updateAccount(Account account) throws DataAccessException;

	//수정위해 정보가져오기
	Account getAccount(String username, String password)throws DataAccessException;
	
	//id로 정보가져오기
	Account getAccountById(String username) throws DataAccessException;
}