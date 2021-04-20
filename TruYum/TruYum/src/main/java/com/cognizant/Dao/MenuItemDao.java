package com.cognizant.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.MenuItem;

@Repository
public interface MenuItemDao extends JpaRepository<MenuItem, Integer>{

}
