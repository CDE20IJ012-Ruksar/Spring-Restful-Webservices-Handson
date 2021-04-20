package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.ItemNotFoundException;
import com.cognizant.model.MenuItem;
import com.cognizant.service.MenuItemService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author kumar
 * MenuItem Controller class having the functionality of
 * show the all admin list
 * 
 *
 */
@RestController
@Slf4j
public class MenuItemController {
	
	@Autowired
	private MenuItemService menuItemService;

	/**
	 * 
	 * @return All the menu items for admin
	 * 
	 */
	@GetMapping("/show-menu-list-admin")
	public List<MenuItem> showMenuItemListAdmin(){
		log.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		log.debug("Admin Menu List: {}", menuItemList);
		log.info("End");
		return menuItemList;
	}
	/**
	 * 
	 * @return All the menu items for customer
	 * 
	 */
	@GetMapping("/show-menu-list-customer")
	public List<MenuItem> showMenuItemListCustomer(){
		log.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		log.debug("Admin Menu List: {}", menuItemList);
		log.info("End");
		return menuItemList;
	}

	/**
	 * 
	 * @param id
	 * @return the Menu Item based on item id  variable
	 *
	 */

	@GetMapping("/show-menu-item/{id}")
	public MenuItem showEditMenuItem(@PathVariable int id) {
		log.info("Start");
		MenuItem item = menuItemService.getMenuItem(id);
		log.debug("Items:{}", item);
		log.info("End");
		return item;
	}
	/**
	 * 
	 * @param menuItem
	 * @return if menItem  is present it update the item  and return Updated successfully or return not updated message
	 * @throws ItemNotFoundException 
	 */

	@PutMapping("/edit-menu-item")
	public String editMenuItem(@RequestBody MenuItem menuItem) throws ItemNotFoundException {
		log.info("started");
		String s=menuItemService.editMenuItem(menuItem);
		log.info("ended");
		return s;
	}
	



}