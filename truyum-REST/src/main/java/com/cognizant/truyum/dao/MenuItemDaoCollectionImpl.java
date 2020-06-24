package com.cognizant.truyum.dao;

//import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
import java.util.Locale;
//import com.cognizant.tyutil.DateUtil;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
//import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
//import org.thymeleaf.util.DateUtils;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);
	private static List<MenuItem> MENU_ITEMS;

	public MenuItemDaoCollectionImpl() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("menuItem.xml");
		MENU_ITEMS = (List<MenuItem>) ctx.getBean("menuItems");
		LOGGER.debug("MenuItems:{}", MENU_ITEMS);
	}

	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem>menuItemListCustomer=new ArrayList<MenuItem>();
		Date date=new Date();
		LocalDateTime localDateTime=LocalDateTime.now();
		String format = DateTimeFormatter.ofPattern("dd/mm/yyyy",Locale.ENGLISH).format(localDateTime);
		Date currentSystemDate = DateUtil.convertToDate(format);
		
				
		for(MenuItem menuItemIterator:MENU_ITEMS) {
			if((menuItemIterator.isActive()==true)&&(menuItemIterator.getDateOfLaunch().compareTo(currentSystemDate)<0)){
				menuItemListCustomer.add(menuItemIterator);
				
			}
		}
	return menuItemListCustomer;
	}

	public MenuItem getMenuItemById(long id) throws MenuItemNotFoundException {
		MenuItem menuItemname=null;
		for (MenuItem menuItem : MENU_ITEMS) {
			if(menuItem.getId()==id) {
				menuItemname=menuItem;
			}
		}if(menuItemname==null)
			throw new MenuItemNotFoundException("MenuItemNotFoundException");
		else
		return menuItemname;
	}

	@Override
	public void ModifyMenuItem(MenuItem menuitem) {
		// TODO Auto-generated method stub
		MenuItem item=null;
		for (MenuItem menuItem2 : MENU_ITEMS) {
			if(menuitem.getId()==menuItem2.getId()) {
				menuItem2.setPrice(menuitem.getPrice());
				item=menuItem2;
				}
		}

}
}
