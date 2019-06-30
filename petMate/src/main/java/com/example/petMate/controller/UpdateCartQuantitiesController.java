package com.example.petMate.controller;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.petMate.domain.Cart;
import com.example.petMate.domain.CartItem;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes("sessionCart")
public class UpdateCartQuantitiesController { 

	@RequestMapping("/updateCartQuantities.do")
	public ModelAndView handleRequest(
			HttpServletRequest request,	
			@ModelAttribute("sessionCart") Cart cart) throws Exception {
		Iterator<CartItem> cartItems = cart.getAllCartItems();
		while (cartItems.hasNext()) {
			CartItem cartItem = (CartItem) cartItems.next();
			int itemId = cartItem.getItem().getI_idx();
			try {
				int quantity = Integer.parseInt(request.getParameter(Integer.toString(itemId)));
				cart.setQuantityByItemId(itemId, quantity);
				if (quantity < 1) {
					cartItems.remove();
				}
			}
			catch (NumberFormatException ex) {
				// ignore on purpose
			}
		}
		return new ModelAndView("Cart", "cart", cart);
	}
}

