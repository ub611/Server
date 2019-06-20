package com.example.petMate.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.petMate.domain.Account;
import com.example.petMate.domain.Cart;
import com.example.petMate.domain.Item;
import com.example.petMate.domain.LineItem;
import com.example.petMate.service.OrderFormValidator;
import com.example.petMate.service.PetMateFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@SessionAttributes("sessionCart")
public class BuyController {
	private static Logger logger = LoggerFactory.getLogger(BuyController.class);
	private static int buyIdx = 0;
	private static OrderForm of;
	
	@Autowired
	private PetMateFacade petStore;
	//@Autowired
	//private OrderFormValidator orderFormValidator;
	
	@ModelAttribute("orderForm")
	public OrderForm createOrderForm(Account account) {
		return new OrderForm(account);
	}

	@ModelAttribute("bankName")
	public List<String> referenceData() {
		ArrayList<String> bankName = new ArrayList<String>();
		bankName.add("WOORI");
		bankName.add("HANA");
		bankName.add("NH");
		bankName.add("SH");
		bankName.add("KB");
		return bankName;			
	}

	@RequestMapping("/newOrder.do")
	public String initNewOrder(HttpServletRequest request,
			@ModelAttribute("sessionCart") Cart cart,
			@ModelAttribute("orderForm") OrderForm orderForm
			) throws ModelAndViewDefiningException {
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		if (cart != null) {
			// Re-read account from DB at team's request.
			//Account account = petStore.getAccountById(userSession.getAccount().getU_idx());
			
			HttpSession isLogin  = request.getSession();
			if(isLogin.getAttribute("u_idx") != null) {
				Account account = petStore.getAccountById((String)isLogin.getAttribute("u_idx"));//Test
				//Account account = petStore.getAccountById(userSession.getAccount().getU_idx());
				orderForm = createOrderForm(account);
				of = orderForm;
				logger.info("orderForm:" + orderForm.getAccount().getU_idx() + " " + orderForm.getAccount().getU_address() + " " + orderForm.getAccount().getU_phone());
				logger.info("of:" + of.getAccount().getU_idx() + " " + of.getAccount().getU_address() + " " + of.getAccount().getU_phone());
				
				orderForm.getBuy().initOrder(account, cart);
				
				Calendar calendar = Calendar.getInstance();
				java.util.Date date = calendar.getTime();
				orderForm.getBuy().setB_date(date);
				
				request.getSession().setAttribute("orderForm", orderForm);
				
				logger.info("orderForm:" + orderForm.getAccount().getU_idx());
				logger.info("of:" + of.getAccount().getU_idx() + " " + of.getAccount().getU_address() + " " + of.getAccount().getU_phone());
				
				return "NewOrderForm";	
			}
			else
				return "SignInForm";
		}
		else {
			ModelAndView modelAndView = new ModelAndView("Error");
			modelAndView.addObject("message", "An order could not be created because a cart could not be found.");
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}
	
	@RequestMapping("/newOrderSubmitted.do")
	public String bindAndValidateOrder(HttpServletRequest request,
			@ModelAttribute("orderForm") OrderForm orderForm, 
			BindingResult result) {
			// from NewOrderForm
		/*orderFormValidator.validateBankAccount(orderForm, result);
		
		if (result.hasErrors()) return "NewOrderForm";
		
		else {
			return "ConfirmOrder";
		}*/
		
		return "ConfirmOrder";
	}
	
	@RequestMapping(value = "/confirmOrder.do", method = RequestMethod.GET)
	protected ModelAndView confirmOrder(
			@ModelAttribute("orderForm") OrderForm orderForm, 
			SessionStatus status) {
		logger.info("of:" + of.getAccount().getU_idx() + " " + of.getAccount().getU_address() + " " + of.getAccount().getU_phone());
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		of.getBuy().setB_date(date);
		of.getBuy().setB_state("o");
		
		logger.info("orderdate:" + of.getBuy().getB_date());
		of.getBuy().setBuyer_idx(of.getAccount().getU_idx());
		List<LineItem> list = of.getBuy().getLineItems();
		
		for(int i = 0; i< list.size(); i++) {
			logger.info("orderForm:" + of.getAccount().getU_idx());
			logger.info("item" + of.getAccount().getU_idx());
			Item item = list.get(i).getItem();
			logger.info("item" + item.getI_idx());
			petStore.insertBuy(item, of.getBuy());
		}
		
		logger.info("list of size : " + list.size());
		for(int i = 0; i < list.size(); i++) {
			Item item = list.get(i).getItem();
			//petStore.deleteItemImage(item.getI_idx());
			//petStore.deleteItem(list.get(i).getItem().getI_idx());
			petStore.updateItemByIdx(item.getI_idx());
		}
		
		ModelAndView mav = new ModelAndView("ViewOrder");
		mav.addObject("orderForm", of);
		mav.addObject("message", "Thank you, your order has been submitted.");
		status.setComplete();  // remove sessionCart and orderForm from session
		return mav;
	}
}
