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
			+ "FROM item " 
			+ "WHERE user_u_idx=#{u_idx}")		//item idx join
	Item getItem(@Param("u_idx")String u_idx);
	
	/*i_title, i_price, i_stock, i_detail, i_date
	 *
	 * */
	
	@Select("SELECT * "
			+ "FROM buy, item " 
			+ "WHERE buy.buyer_idx=#{u_idx} AND item.i_idx=buy.item_i_idx")		
	buy getBuyIamBuyer(@Param("u_idx")String u_idx);
	
	/*buy,b_date, buy.seller_idx, item.i_title, item.i_price, item.i_detail*/
	
	
	@Select("SELECT * "
			+ "FROM pet, adopt, category "
			+ "WHERE adopt.adopter_idx=#{u_idx} AND pet.p_cate=category.c_idx")			//category조인
	Pet getIamAdopter(@Param("u_idx")String u_idx);
	/*pet.p_age, pet.p_gender, pet.p_name, pet.p_isInjection, 
	 * pet.p_cate_detail, adopt.owner_idx, adopt.a_state, adopt.a_date, category.c_name*/
	
	
	@Select("SELECT * "
			+ "FROM pet, category " 
			+ "WHERE pet.user_u_idx=#{username} AND pet.p_cate=category.c_idx")		//pet_p_idx join
	Adopt getPet(@Param("u_idx")String u_idx);
	/*pet.p_age, pet.p_gender, pet.p_name, pet.p_isInjection, pet.p_cate_detail, category.c_name*/
	

	

}
