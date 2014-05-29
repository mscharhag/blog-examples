package com.mscharhag.springjooq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private int price;

	public Long getId() {
		return id;
	}
	@Column(name = "id")
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	@Column(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	@Column(name = "price")
	public void setPrice(int price) {
		this.price = price;
	}
}
