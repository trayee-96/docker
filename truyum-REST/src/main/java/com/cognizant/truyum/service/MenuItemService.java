package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
@Service
public class MenuItemService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);
@Autowired
private MenuItemDao dao;
public List<MenuItem> getMenuItemListCustomer(){
	LOGGER.info("Start");
	return dao.getMenuItemListCustomer();
	
}
public MenuItem getMenuItemById(long id) throws MenuItemNotFoundException {
	// TODO Auto-generated method stub
	return dao.getMenuItemById(id);
}
public void modifyMenuItem(MenuItem menuitem) {
	 dao.ModifyMenuItem(menuitem);
}
}
