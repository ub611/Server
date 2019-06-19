package com.example.petMate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.example.petMate.service.AccountFormValidator;
import com.example.petMate.service.PetMateFacade;

@Controller
@RequestMapping("/signup.do")
public class SignUpController {
	private static Logger logger = LoggerFactory.getLogger(SignUpController.class);

	private PetMateFacade petMate;
	
	@Autowired
	public void setPetStore(PetMateFacade petMate) {
		this.petMate = petMate;
	}
	
	@Value("EditAccountForm")
	private String formViewName;
	
	@Value("index")
	private String successViewName;
	
//	@Autowired
//	private AccountFormValidator validator;
//	public void setValidator(AccountFormValidator validator) {
//		this.validator = validator;
//	}
		
	//내 거래내역, 내 펫 등록내역 보여줘야함
	
	@ModelAttribute("accountForm")
	public AccountForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		HttpSession session = request.getSession(); 
		if (session != null) {	// edit an existing account
			return new AccountForm(petMate.getAccountById((String)session.getAttribute("u_idx")));
		}
		else {	// create a new account
			return new AccountForm();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("accountForm") AccountForm accountForm,
			BindingResult result) throws Exception {

//		if (request.getParameter("account.listOption") == null) {
//			accountForm.getAccount().setListOption(false);
//		}
//		if (request.getParameter("account.bannerOption") == null) {
//			accountForm.getAccount().setBannerOption(false);
//		}
		
//		validator.validate(accountForm, result);
		
		if (result.hasErrors()) return formViewName;
		
		try {
			if (accountForm.isNewAccount()) {
				petMate.insertAccount(accountForm.getAccount());
			}
			else {
				petMate.updateAccount(accountForm.getAccount());
			}
		}
		catch (DataIntegrityViolationException ex) {
			result.rejectValue("account.username", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName; 
		}
//		
//		UserSession userSession = new UserSession(
//			petStore.getAccount(accountForm.getAccount().getUsername()));
//		PagedListHolder<Product> myList = new PagedListHolder<Product>(
//			petStore.getProductListByCategory(accountForm.getAccount().getFavouriteCategoryId()));
//		myList.setPageSize(4);
//		userSession.setMyList(myList);
//		session.setAttribute("userSession", userSession);
		return successViewName;  
	}
	

}
