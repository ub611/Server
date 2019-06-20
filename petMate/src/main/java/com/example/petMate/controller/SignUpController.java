package com.example.petMate.controller;

import java.beans.PropertyEditorSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;
import com.example.petMate.service.AccountFormValidator;
import com.example.petMate.service.PetMateFacade;

@Controller
public class SignUpController {
	private static Logger logger = LoggerFactory.getLogger(SignUpController.class);

	private PetMateFacade petMate;

	@Autowired
	public void setPetStore(PetMateFacade petMate) {
		this.petMate = petMate;
	}

	@Value("MyPage")
	private String formViewName;

	@Value("index")
	private String successViewName;

	@Autowired
	private AccountFormValidator validator;
	public void setValidator(AccountFormValidator validator) {
		this.validator = validator;
	}

	//내 거래내역, 내 펫 등록내역 보여줘야함

	@ModelAttribute("AccountForm")
	public AccountForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		HttpSession session = request.getSession(); 
		String isLogin = (String) session.getAttribute("u_idx");
		if (isLogin != null) {	// edit an existing account
			return new AccountForm(petMate.getAccountById((String)session.getAttribute("u_idx")));
		}
		else {	// create a new account
			return new AccountForm();
		}
	}

	@RequestMapping(value="/signup.do", method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}

	@RequestMapping(value="/signup.do", method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("AccountForm") AccountForm account,
			BindingResult result) throws Exception {


		validator.validate(account, result);

		if (result.hasErrors()) return formViewName;


		try {
			logger.info(account.getAccount().toString());
			petMate.insertAccount(account.getAccount());

		}
		catch (DataIntegrityViolationException ex) {
			result.rejectValue("account.u_idx", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName; 
		}
		
		return successViewName;  
	}

}
