package com.cognizant.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cart")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn
	private User user;
	@ManyToOne
	@JoinColumn
	private MenuItem menuItem;
	public Cart(User user,MenuItem item) {
		this.user=user;
		this.menuItem=item;
	}
	
}