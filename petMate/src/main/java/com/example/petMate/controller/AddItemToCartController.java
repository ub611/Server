package com.example.petMate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.example.petMate.domain.Cart;
import com.example.petMate.domain.Item;
import com.example.petMate.service.PetMateFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes("sessionCart")
public class AddItemToCartController { 
	private static Logger logger = LoggerFactory.getLogger(ItemController.class);

	private PetMateFacade petStore;

	@Autowired
	public void setPetStore(PetMateFacade petStore) {
		this.petStore = petStore;
	}

	@ModelAttribute("sessionCart")
	public Cart createCart() {
		return new Cart();
	}
	
	@RequestMapping("/addCart.do")
	public ModelAndView handleRequest(
			@RequestParam("itemId") int itemId,
			@ModelAttribute("sessionCart") Cart cart 
			) throws Exception {
		if (cart.containsItemId(itemId)) {
			cart.incrementQuantityByItemId(itemId);
		}
		else {
			// isInStock is a "real-time" property that must be updated
			// every time an item is added to the cart, even if other
			// item details are cached.
			//boolean isInStock = cart.itemInCart(itemId).isInStock();
			logger.info("cart : " + cart.getNumberOfItems());
			Item item = this.petStore.getItemByItemIdx(itemId);
			cart.addItem(item);
			logger.info("cart : " + cart.getNumberOfItems());
		}
		return new ModelAndView("Cart", "cart", cart);
	}
}
