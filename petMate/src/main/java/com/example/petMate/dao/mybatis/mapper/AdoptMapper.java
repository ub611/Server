package com.example.petMate.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.petMate.domain.Adopt;

public interface AdoptMapper {
	
	@Select({"SELECT * FROM adopt"})
	List<Adopt> selectAdoptList();

	@Select({"SELECT * FROM adopt "
			+ "WHERE a_idx=#{a_idx}"})
	Adopt selectAdoptByIdx(int a_idx);
	
//	@Select({"SELECT * FROM adopt "
//			+ "WHERE a_idx=#{a_idx}"})
//	Adopt selectAdoptByIdx(int a_idx);
	
	@Select({"SELECT * FROM adopt "
			+ "WHERE pet_p_idx=#{pet_p_idx}"})
	Adopt selectAdoptByPet(int pet_p_idx);

	@Insert("INSERT INTO adopt(a_date, a_state, a_title, a_content,"
			+ "adopter_idx, owner_idx, pet_p_idx) "
			+ "VALUES(#{a_date}, #{a_state}, #{a_title}, #{a_content}, "
			+ "0, #{owner_idx}, #{pet_p_idx})")
	int insertAdopt(Adopt adopt);
	
	@Update({"UPDATE adopt SET "
			+ "a_state='l', a_title=#{a_title}, a_content=#{a_content}, "
			+ "pet_p_idx=1 "
			+ "WHERE a_idx=#{a_idx}"})
	int updateAdopt(Adopt adopt);  
	
	@Delete("DELETE FROM adopt "
			+ "WHERE a_idx=#{a_idx}")
	int deleteAdopt(int a_idx);

	@Delete("DELETE FROM adopt "
			+ "WHERE pet_p_idx=#{p_idx}")
	int deleteAdoptByPet(int p_idx);
}
