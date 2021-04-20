package com.cognizant.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Dao.MenuItemDao;
import com.cognizant.exception.ItemNotFoundException;
import com.cognizant.model.MenuItem;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class MenuItemServiceImpl implements MenuItemService{

	@Autowired
	private MenuItemDao md;
	/**
	 * 
	 * @return All the menu items for admin
	 * 
	 */
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		log.info("started get all items service");
		List<MenuItem> l=md.findAll();
		System.out.println(l);
		log.info("ended");
		return l;
		
	}
	/**
	 * 
	 * @param id
	 * @return the Menu Item based on item id  variable
	 *
	 */
	@Override
	public MenuItem getMenuItem(int id) {
		log.info("started get item service");
		MenuItem i=md.findById(id).get();
		log.info("ended");
		return i;
	}
	/**
	 * 
	 * @param menuItem
	 * @return if menItem  is present it update the item  and return Updated successfully or return not updated message
	 * @throws ItemNotFoundException 
	 */
	@Override
	public String editMenuItem(MenuItem menuItem) throws ItemNotFoundException {
		log.info("started edit item service");
		Optional<MenuItem> m=md.findById(menuItem.getId());
		if(m.isPresent()) {
			md.save(menuItem);
			log.info("ended");
			return "Item Updated Successfully";
		}
		log.info("ended");
		throw new  ItemNotFoundException("Item Not found");
	}
	/**
	 * 
	 * @return All the menu items for customer
	 * 
	 */
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		log.info("started get all items service");
		List<MenuItem> l=md.findAll().stream().filter(o->(o.getDateOfLaunch().before(new Date())&&(o.isActive()))).collect(Collectors.toList());
		System.out.println(l);
		log.info("ended");
		return l;
	}

}
