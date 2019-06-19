package com.example.petMate.dao.mybatis.mapper;

import org.apache.ibatis.annotations.*;

import com.example.petMate.domain.Account;
import com.example.petMate.domain.Adopt;
import com.example.petMate.domain.Item;
import com.example.petMate.domain.Pet;
import com.example.petMate.domain.buy;

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
	
	@Select("SELECT * "
			+ "FROM buy " 
			+ "WHERE buyer_idx=#{username}")		//buyer_idx join
	buy getBuyHistory(@Param("username")String username);
	
	
	@Select("SELECT * "
			+ "FROM item " 
			+ "WHERE user_u_idx=#{username}")		//item idx join
	Item getItem(@Param("username")String username);
	
	@Select("SELECT * "
			+ "FROM adopt " 
			+ "WHERE owner_idx=#{username}")		//pet_p_idx join
	Adopt getAdoptHistory(@Param("username")String username);
	
	
	@Select("SELECT * "
			+ "FROM pet "
			+ "WHERE user_u_idx=#{username}")			//category조인
	Pet getPet(@Param("username") String username);
	

}
