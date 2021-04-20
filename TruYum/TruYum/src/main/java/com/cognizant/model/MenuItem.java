package com.cognizant.model;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

	@Id
	private int id;
	private String name;
	private float price;
	private boolean active;
	private Date dateOfLaunch;
	private String category;
	private String freeDelivery;
	@JsonIgnore
	@OneToMany(mappedBy = "menuItem", fetch = FetchType.LAZY,orphanRemoval = true)
	private List<Cart> carts;
	
	
}