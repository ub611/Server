package com.example.petMate.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.example.petMate.domain.Adopt;
import com.example.petMate.domain.Pet;

public interface PetMapper {

	@Select({"SELECT * FROM pet"})
	List<Pet> selectPetList();
	
	@Select({"SELECT * FROM pet "
			+ "WHERE p_idx=#{p_idx}"})
	Pet selectPetByIdx(int p_idx);
	
	@Select({"SELECT * FROM pet "
			+ "WHERE user_u_idx=#{user_u_idx}"})
	List<Pet> selectPetByUserIdx(int user_u_idx);
	
//	@Select({"SELECT adopt.a_idx, a_title, a_content, pet.p_name "
//			+ "FROM adopt, pet "
//			+ "WHERE adopt.pet_p_idx=pet.p_idx"})
//	@Results({
//		@Result(column="a_idx", property="a_idx", jdbcType=JdbcType.NUMERIC, id=true),
//		@Result(column="a_title", property="a_title", jdbcType=JdbcType.VARCHAR),
//		@Result(column="a_content", property="a_content", jdbcType=JdbcType.VARCHAR),
//		@Result(column="pet_p_idx", property="pet_p_idx", jdbcType=JdbcType.NUMERIC),
//		@Result(column="p_idx", property="pet.p_idx", jdbcType=JdbcType.NUMERIC),
//		@Result(column="p_name", property="pet.p_name", jdbcType=JdbcType.VARCHAR)
//	})
//	List<Adopt> selectPetImageByAdopt();
	
	@Select({"SELECT p_name "
			+ "FROM pet "
			+ "WHERE p_idx=#{pet_p_idx}"})
	String selectPetNameByAdopt(int pet_p_idx);
	@Select({"SELECT p_age "
			+ "FROM pet "
			+ "WHERE p_idx=#{pet_p_idx}"})
	int selectPetAgeByAdopt(int pet_p_idx);
	@Select({"SELECT p_idx "
			+ "FROM pet "
			+ "ORDER BY p_idx DESC LIMIT 1"})
	int selectPetIdxLatest();
	
	@Select("SELECT pi_url "
			+ "FROM pet, pet_image "
			+ "WHERE pet.p_idx = pet_image.pet_p_idx AND pet.p_idx= #{p_idx}")
	String[] selectPetImageUrls(int p_idx);
	
	@Insert("INSERT INTO pet(p_age, p_gender, p_name, p_isInjection, p_cate, p_cate_detail, "
			+ "user_u_idx, category_c_idx, p_url) "
			+ "VALUES(#{pet.p_age}, #{pet.p_gender}, #{pet.p_name}, #{pet.p_isInjection}, #{pet.p_cate}, #{pet.p_cate_detail}, " 
			+ "#{pet.user_u_idx}, 0, #{pet.p_url})")
	int insertPet(@Param("pet") Pet pet); 
	
	@Update({"UPDATE pet SET "
			+ "p_age=#{pet.p_age}, p_gender=#{pet.p_gender}, p_isInjection=#{pet.p_isInjection}, p_cate=#{pet.p_cate}, p_cate_detail=#{pet.p_cate_detail}, p_url= #{pet.p_url} "
			+ "WHERE p_idx=#{pet.p_idx}"})
	int updatePet(@Param("pet") Pet pet); 
	
	@Delete("DELETE FROM pet "
			+ "WHERE p_idx=#{p_idx}")
	int deletePet(@Param("p_idx") int p_idx);
	
	@Insert("INSERT INTO pet_image(pet_p_idx, pi_url)  VALUES(#{pet_p_idx}, #{pi_url})")
	int insertPetImage(@Param("pet_p_idx") int pet_p_idx, @Param("pi_url") String pi_url);
	
	@Delete("DELETE FROM pet_image "
			+ "WHERE pet_p_idx=#{pet_p_idx}")
	int deletePetImage(@Param("pet_p_idx") int pet_p_idx);
	
	@Select("SELECT p_url FROM pet WHERE p_idx=#{pet_p_idx}")
	String selectUrlByIdx(@Param("pet_p_idx") int pet_p_idx);
	
	@Select("SELECT * FROM pet ORDER BY p_idx DESC")
	List<Pet> selectAllPets();
}
