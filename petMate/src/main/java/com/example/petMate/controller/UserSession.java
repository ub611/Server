package com.example.petMate.controller;

import java.io.Serializable;
import org.springframework.beans.support.PagedListHolder;

import com.example.petMate.domain.Account;
import com.example.petMate.domain.Item;

@SuppressWarnings("serial")
public class UserSession implements Serializable {

	private Account account;
	private PagedListHolder<Item> myList;


	public UserSession(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setMyList(PagedListHolder<Item> myList) {
		this.myList = myList;
	}

	public PagedListHolder<Item> getMyList() {
		return myList;
	}
}
