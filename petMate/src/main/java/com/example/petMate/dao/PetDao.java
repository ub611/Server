package com.example.petMate.dao;

import java.util.List;
import java.util.Map;

import com.example.petMate.domain.Adopt;
import com.example.petMate.domain.Pet;

public interface PetDao {
	List<Pet> selectPetList();
	Pet selectPetByIdx(int p_idx);
	List<Pet> selectPetByUserIdx(int u_idx);
	String selectPetNameByAdopt(int pet_p_idx);
	String selectPetAgeByAdopt(int pet_p_idx);
	int selectPetIdxLatest();
	int insertPet(Pet pet);
	int updatePet(Pet pet);
	int deletePet(int p_idx);
	
	int insertPetImage(int p_idx, String pi_url);
	int deletePetImage(int p_idx);
	
	String selectUrlByIdx(int p_idx);
}