package com.example.petMate.dao;

import java.util.List;

import com.example.petMate.domain.Adopt;


public interface AdoptDao {
	List<Adopt> selectAdoptList();
	Adopt selectBoardByIdx(int a_idx);
	Adopt selectAdoptByPet(int pet_p_idx);
	int insertAdopt(Adopt adopt);
	int updateAdopt(Adopt adopt);
	int deleteAdopt(int a_idx);
	int deleteAdoptByPet(int p_idx);
}
