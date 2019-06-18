package com.example.petMate.dao.mybatis.mapper;

import org.apache.ibatis.annotations.*;

import com.example.petMate.domain.Account;

public interface AccountMapoer {
	@Insert("INSERT INTO user VALUES (#{u_idx}, #{u_name}, #{u_address}. #{u_phone}, #{u_pw}, #{u_salt}, #{u_profile})")
	@Options(useGeneratedKeys = true, keyProperty = "u_idx")
	void insertAccount(Account account);		//join
	
//	@Select("SELECT * FROM user")
	Account getAccount(String username, String pwd);		//set up for info for update
	
//	@Update("Update user SET #{u_name} = ")
	void updateAccount(Account account);		//update info 

}
