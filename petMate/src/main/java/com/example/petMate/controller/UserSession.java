package com.example.petMate.controller;

import java.io.Serializable;
import org.springframework.beans.support.PagedListHolder;

import com.example.petMate.domain.Account;

@SuppressWarnings("serial")
public class UserSession implements Serializable {

	private Account account;


	public UserSession(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

}
