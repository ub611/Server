package com.example.petMate.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.example.petMate.command.MyPageAdoptCommand;
import com.example.petMate.command.MyPageBuyCommand;
import com.example.petMate.command.MyPageItemCommand;
import com.example.petMate.command.MyPagePetCommand;
import com.example.petMate.domain.Account;
import com.example.petMate.domain.Adopt;
import com.example.petMate.domain.Item;
import com.example.petMate.domain.Pet;
import com.example.petMate.domain.buy;

public interface AccountDao {

	//회원가입
	void insertAccount(Account account) throws DataAccessException;

	//회원정보 수정
	void updateAccount(Account account) throws DataAccessException;

	//수정위해 정보가져오기
	Account getAccount(String username, String password)throws DataAccessException;
	
	//id로 정보가져오기
	Account getAccountById(String username) throws DataAccessException;
	
	//내가 파는 아이템 가져오기
	List<MyPageItemCommand> getItem(String u_idx);
	
	//내 구입목록
	List<MyPageBuyCommand> getBuyIamBuyer(String u_idx);

	//내 입양목록
	List<MyPageAdoptCommand> getIamAdopter(String u_idx);
	
	//내가 분양시킨 펫들
	List<MyPagePetCommand> getPet(String u_idx);
}