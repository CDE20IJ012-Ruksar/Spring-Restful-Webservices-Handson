package com.cognizant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.exception.ItemNotFoundException;
import com.cognizant.model.MenuItem;

@Service
public interface MenuItemService {
	public List<MenuItem> getMenuItemListAdmin();
	public MenuItem getMenuItem(int id);
	public String editMenuItem(MenuItem menuItem) throws ItemNotFoundException;
	public List<MenuItem> getMenuItemListCustomer();
}
