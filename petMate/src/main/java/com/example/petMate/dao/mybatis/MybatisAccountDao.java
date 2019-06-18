package com.example.petMate.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.petMate.dao.AccountDao;
import com.example.petMate.dao.mybatis.mapper.AccountMapper;
import com.example.petMate.domain.Account;

@Repository
public class MybatisAccountDao implements AccountDao{

	@Autowired
	private AccountMapper accountmapper;
	
	@Override
	public void insertAccount(Account account) throws DataAccessException{
		// TODO Auto-generated method stub
		accountmapper.insertAccount(account);
		
	}

	@Override
	public void updateAccount(Account account) throws DataAccessException{
		// TODO Auto-generated method stub
		accountmapper.updateAccount(account);
		
	}

	@Override
	public Account getAccount(String username, String password) throws DataAccessException{
		// TODO Auto-generated method stub
		return accountmapper.getAccount(username, password);
	}

	@Override
	public Account getAccountById(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return accountmapper.getAccountById(username);
	}
	
	
	

}
