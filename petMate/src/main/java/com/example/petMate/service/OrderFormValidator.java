package com.example.petMate.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.petMate.controller.OrderForm;
import com.example.petMate.domain.Account;
import com.example.petMate.domain.buy;

@Component
public class OrderFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return buy.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		validateBankAccount((OrderForm) obj, errors);
		validateBillingAddress((Account) obj, errors);
	}

	public void validateBankAccount(OrderForm orderForm, Errors errors) {
		errors.setNestedPath("orderForm");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountNumber", "CCN_REQUIRED", "FAKE (!) account number required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankName", "ACCOUNT_TYPE_REQUIRED", "Bank Name is required.");
		errors.setNestedPath("");
	}

	public void validateBillingAddress(Account account, Errors errors) {
		errors.setNestedPath("account");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "u_address", "FIRST_NAME_REQUIRED", "Billing Info: first name is required.");
		errors.setNestedPath("");
	}

	
}
