package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
@Repository
public class CartDaoCollectionImpl implements CartDao{
private static Map<String,Cart>customerCartMap=new HashMap<String,Cart>();
	
	@Autowired
	private MenuItemService menuItemService;
	
	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		MenuItem menuItem=menuItemService.getMenuItemById(menuItemId);
		if(customerCartMap.containsKey(userId)) {
			Cart userCartPrevious = customerCartMap.get(userId);
			List<MenuItem> itemListUser = userCartPrevious.getMenuItemList();
			double total = userCartPrevious.getTotal();
			itemListUser.add(menuItem);
			total+=menuItem.getPrice();
			userCartPrevious.setMenuItemList(itemListUser);
			userCartPrevious.setTotal(total);
			customerCartMap.put(userId, userCartPrevious);
		}
		else {
			Cart userCartNew = new Cart();
			List<MenuItem>newList=new ArrayList<MenuItem>();
			newList.add(menuItem);
			userCartNew.setMenuItemList(newList);
			userCartNew.setTotal(menuItem.getPrice());
			customerCartMap.put(userId, userCartNew);
			}
		
			
	}

	@Override
	public List<MenuItem> getAllCartItems(String userId)  {
		Cart cart=customerCartMap.get(userId);
		return cart.getMenuItemList();
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		// TODO Auto-generated method stub
		MenuItem menu=menuItemService.getMenuItemById(menuItemId);
		Cart cart=customerCartMap.get(userId);
		List<MenuItem> list=cart.getMenuItemList();
		list.remove(menu);
		double total=cart.getTotal();
		total-=menu.getPrice();
		cart.setMenuItemList(list);
		cart.setTotal(total);
		customerCartMap.put(userId, cart);
	}

}
