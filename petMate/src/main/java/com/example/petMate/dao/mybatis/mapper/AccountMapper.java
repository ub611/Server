package com.example.petMate.dao.mybatis.mapper;

import org.apache.ibatis.annotations.*;

import com.example.petMate.domain.Account;
import com.example.petMate.domain.Adopt;
import com.example.petMate.domain.Item;
import com.example.petMate.domain.Pet;
import com.example.petMate.domain.buy;

public interface AccountMapper {
	@Select("SELECT * "
			+ "FROM user "
			+ "WHERE u_idx=#{username} AND u_pw=#{password}")
	Account getAccount(@Param("username")String username, @Param("password")String password);		//set up for info for update
	
	@Select("SELECT * "
			+ "FROM user "
			+ "WHERE u_idx=#{username}")
	Account getAccountById(@Param("username")String username);

	
	@Insert("INSERT INTO user "
			+ "VALUES(#{account.u_idx}, #{account.u_name}, #{account.u_address}, "
			+ "#{account.u_phone}, #{account.u_pw}, 123, #{account.u_profile})")
	void insertAccount(@Param("account")Account account);
	
	@Update("UPDATE user SET u_name=#{account.u_name}, u_pw=#{account.u_pw}, "
			+ "u_address=#{account.u_address}, u_phone=#{account.u_phone} "
			+ "WHERE u_idx=#{account.u_idx}")
	void updateAccount(@Param("account")Account account);		//update info 

	
	//PetmateFacade에없음
	
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
