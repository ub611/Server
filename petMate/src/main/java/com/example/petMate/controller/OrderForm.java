package com.example.petMate.controller;

import com.example.petMate.domain.Account;
import com.example.petMate.domain.buy;

public class OrderForm {
	private final Account account;
	private final buy buy = new buy();
	private String bankName;
	private String accountNumber;
	
	public OrderForm(Account account) {
		this.account = account;
	}
	

	public Account getAccount() {
		return account;
	}
	
	public buy getBuy() {
		return buy;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	
}
