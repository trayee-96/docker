package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
@Service
public class CartService {
@Autowired
private CartDao cartdao;
public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
	try {
		cartdao.addCartItem(userId, menuItemId);
	} catch (MenuItemNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public List<MenuItem> getAllCartItems(String userId){
	return cartdao.getAllCartItems(userId);
}
public void deleteMenuItem(String userId,long menuItemId) throws MenuItemNotFoundException {
	cartdao.removeCartItem(userId, menuItemId);
}
}
