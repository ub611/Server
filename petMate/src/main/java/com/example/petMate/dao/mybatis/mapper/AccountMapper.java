package com.example.petMate.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.petMate.command.MyPageAdoptCommand;
import com.example.petMate.command.MyPageBuyCommand;
import com.example.petMate.command.MyPageItemCommand;
import com.example.petMate.command.MyPagePetCommand;
import com.example.petMate.domain.Account;

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
	void updateAccount(@Param("account")Account account);		

	//PetmateFacade에없음
	
	@Select("SELECT * "
			+ "FROM item " 
			+ "WHERE user_u_idx=#{u_idx}")		
	List<MyPageItemCommand> getItem(@Param("u_idx")String u_idx);

	
	@Select("SELECT * "
			+ "FROM buy, item " 
			+ "WHERE buy.buyer_idx=#{u_idx} AND item.i_idx=buy.item_i_idx")		
	List<MyPageBuyCommand> getBuyIamBuyer(@Param("u_idx")String u_idx);
	
	
	@Select("SELECT * "
			+ "FROM pet, adopt, category "
			+ "WHERE adopt.adopter_idx=#{u_idx} AND pet.p_cate=category.c_idx")
	List<MyPageAdoptCommand> getIamAdopter(@Param("u_idx")String u_idx);
	
	
	@Select("SELECT * "
			+ "FROM pet, category " 
			+ "WHERE pet.user_u_idx=#{u_idx} AND pet.p_cate=category.c_idx")
	List<MyPagePetCommand> getPet(@Param("u_idx")String u_idx);
	
	
	

	

}
