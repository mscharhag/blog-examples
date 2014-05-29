package com.mscharhag.springjooq.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String email;

	@OneToMany
	private List<Order> orders;

	public String getName() {
		return name;
	}

	@Column(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	@Column(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	@Column(name = "id")
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
