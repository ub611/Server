package com.example.petMate.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.petMate.dao.PetDao;
import com.example.petMate.dao.mybatis.mapper.PetMapper;
import com.example.petMate.domain.Adopt;
import com.example.petMate.domain.Pet;

@Repository
public class MybatisPetDao implements PetDao {
	private static Logger logger = LoggerFactory.getLogger(MybatisPetDao.class);

	@Autowired
	private PetMapper petMapper;
	
	@Override
	public List<Pet> selectPetList() {
		return petMapper.selectPetList();
	}

	@Override
	public Pet selectPetByIdx(int p_idx) {
		return petMapper.selectPetByIdx(p_idx);
	}

	@Override
	public List<Pet> selectPetByUserIdx(int u_idx) {
		return petMapper.selectPetByUserIdx(u_idx);
	}
	
	@Override
	public String selectPetNameByAdopt(int pet_p_idx) {
		return petMapper.selectPetNameByAdopt(pet_p_idx);
	}
	@Override
	public String selectPetAgeByAdopt(int pet_p_idx) {
		return String.valueOf(petMapper.selectPetAgeByAdopt(pet_p_idx));
	}
	@Override 
	public int selectPetIdxLatest() {
		return petMapper.selectPetIdxLatest();
	}
	@Override
	public int insertPet(Pet pet) {
		return petMapper.insertPet(pet);
	}

	@Override
	public int updatePet(Pet pet) {
		return petMapper.updatePet(pet);
	}

	@Override
	public int deletePet(int p_idx) {
		return petMapper.deletePet(p_idx);
	}

	@Override
	public int insertPetImage(int p_idx, String pi_url) {
		// TODO Auto-generated method stub
		return petMapper.insertPetImage(p_idx, pi_url);
	}

	@Override
	public int deletePetImage(int p_idx) {
		// TODO Auto-generated method stub
		return petMapper.deletePetImage(p_idx);
	}

	@Override
	public String selectUrlByIdx(int p_idx) {
		// TODO Auto-generated method stub
		return petMapper.selectUrlByIdx(p_idx);
	}

	@Override
	public List<Pet> selectAllPets() {
		// TODO Auto-generated method stub
		return petMapper.selectAllPets();
	}
	
	
}
