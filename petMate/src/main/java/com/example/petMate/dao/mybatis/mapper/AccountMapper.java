package com.example.petMate.dao.mybatis.mapper;

import org.apache.ibatis.annotations.*;

import com.example.petMate.domain.Account;

public interface AccountMapper {
//	@Insert("INSERT INTO user VALUES (#{u_idx}, #{u_name}, #{u_address}. #{u_phone}, #{u_pw}, #{u_salt}, #{u_profile})")
	void insertAccount(Account account);		//join
	
	@Select("SELECT * "
			+ "FROM user "
			+ "WHERE u_idx=#{username} AND u_pw=#{password}")
	Account getAccount(@Param("username")String username, @Param("password")String password);		//set up for info for update
	
	@Select("SELECT * "
			+ "FROM user "
			+ "WHERE u_idx=#{username}")
	Account getAccountById(@Param("username")String username);

	//	@Update("Update user SET #{u_idx} = ")
	void updateAccount(Account account);		//update info 
	
	

}
