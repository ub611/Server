package com.example.petMate.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.petMate.controller.AccountForm;
import com.example.petMate.controller.SignUpController;
import com.example.petMate.domain.Account;

@Component
public class AccountFormValidator implements Validator {
	private static Logger logger = LoggerFactory.getLogger(AccountFormValidator.class);

	public boolean supports(Class<?> clazz) {
		return Account.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		AccountForm accountForm = (AccountForm)obj;
		Account account = accountForm.getAccount();

		//수정하
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.u_idx", "ID_REQUIRED", "Id is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.u_name", "NAME_REQUIRED", "name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.u_phone", "PHONE_REQUIRED", "phone address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.u_address", "ADDRESS_REQUIRED", "address number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.u_pw", "PASSWORD_REQUIRED", "password is required.");
		
		
		if (accountForm.isNewAccount()) {
			//account.setStatus("OK");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.u_idx", "USER_ID_REQUIRED", "User ID is required.");
			
			if (account.getU_pw() == null || account.getU_pw().length() < 1 ||
					!account.getU_pw().equals(accountForm.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH",
					 "Passwords did not match or were not provided. Matching passwords are required.");
			}
		}
		else if (account.getU_pw() != null && account.getU_pw().length() > 0) {
			if (!account.getU_pw().equals(accountForm.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH", "Passwords did not match. Matching passwords are required.");
			}
		}
		
	}

}