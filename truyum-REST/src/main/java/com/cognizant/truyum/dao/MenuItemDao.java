package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	List<MenuItem> getMenuItemListCustomer() ;
	//public MenuItem getMenuItemById(long id);

	MenuItem getMenuItemById(long id) throws MenuItemNotFoundException;
	void ModifyMenuItem(MenuItem menuitem);
}
