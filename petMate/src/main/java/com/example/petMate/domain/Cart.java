
package com.example.petMate.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.support.PagedListHolder;

@SuppressWarnings("serial")
public class Cart implements Serializable {
	
	/* Private Fields */
	private final Map<Integer, CartItem> itemMap = Collections.synchronizedMap(new HashMap<Integer, CartItem>());
	private final PagedListHolder<CartItem> itemList = new PagedListHolder<CartItem>();

	/* JavaBeans Properties */
	public Cart() {
			this.itemList.setPageSize(4);
	}
	
	public Map<Integer, CartItem> getItemMap(){ return itemMap;}
	public Iterator<CartItem> getAllCartItems() { return itemList.getSource().iterator(); }
	public PagedListHolder<CartItem> getCartItemList() { return itemList; }
	public int getNumberOfItems() { return itemList.getSource().size(); }
	
	/* Public Methods */
	public boolean containsItemId(int i_idx) {
		return itemMap.containsKey(i_idx);
	}
	
	public CartItem itemInCart(int i_idx) {
		return itemMap.get(i_idx);
	}
	
	
	public void addItem(Item item) {
		CartItem cartItem = itemMap.get(item.getI_idx());
		
	    if (cartItem == null) {
	      cartItem = new CartItem();
	      cartItem.setItem(item);
	      cartItem.setQuantity(0);
	      //cartItem.setInStock(isInStock);
	      itemMap.put(item.getI_idx(), cartItem);
	      itemList.getSource().add(cartItem);
	    }
	    cartItem.incrementQuantity();
	}
	public Item removeItemById(int i_idx) {
	    CartItem cartItem = itemMap.remove(i_idx);
	    if (cartItem == null) {
	      return null;
	    }
	    else {
	      itemList.getSource().remove(cartItem);
	      return cartItem.getItem();
	    }
	}
	
	public void incrementQuantityByItemId(int i_idx) {
	    CartItem cartItem = itemMap.get(i_idx);
	    cartItem.incrementQuantity();
	}
	
	public void setQuantityByItemId(int i_idx, int quantity) {
	    CartItem cartItem = itemMap.get(i_idx);
	    cartItem.setQuantity(quantity);
	}
	
	public int getSubTotal() {
	    int subTotal = 0;
	    Iterator<CartItem> items = getAllCartItems();
	    while (items.hasNext()) {
	      CartItem cartItem = (CartItem) items.next();
	      subTotal += Integer.parseInt(cartItem.getTotalPrice());
	    }
	    return subTotal;
	}
  }
