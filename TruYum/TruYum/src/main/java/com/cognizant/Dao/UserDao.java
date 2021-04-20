package com.cognizant.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
