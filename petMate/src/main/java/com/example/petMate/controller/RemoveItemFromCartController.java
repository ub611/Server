package com.example.petMate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.petMate.domain.Cart;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes("sessionCart")
public class RemoveItemFromCartController { 

	@RequestMapping("/removeCart.do")
	public ModelAndView handleRequest(
			@RequestParam("itemId") int itemId,
			@ModelAttribute("sessionCart") Cart cart
		) throws Exception {
		cart.removeItemById(itemId);
		return new ModelAndView("Cart", "cart", cart);
	}
}
