package com.mscharhag.springjooq.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany
	private List<Product> products;

	@ManyToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
