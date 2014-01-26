package com.mscharhag.views


class User {
	String name
	Address address

	static mapping = {
		address cascade: 'all'
	}
}
