package com.example.petMate.dao.mybatis.mapper;

import org.apache.ibatis.annotations.*;

import com.example.petMate.domain.Account;

public interface AccountMapoer {
//	  Account getAccountByUsername(String username);
	  
	  Account getAccountByUsernameAndPassword(String username, String password);
	  
	  @Insert("INSERT INTO Students (NAME, EMAIL ) VALUES (#{name},#{email})")
	  @Options(useGeneratedKeys = true, keyProperty = "id")
	  void insertAccount(Account account);
	  
	  void insertProfile(Account account);
	  
	  void insertSignon(Account account);

	  void updateAccount(Account account);

	  void updateProfile(Account account);

	  void updateSignon(Account account);

}
