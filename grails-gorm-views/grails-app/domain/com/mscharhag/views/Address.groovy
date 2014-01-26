package com.mscharhag.views

class Address {

	String street
	String city
	String postalCode
	String country

	static constraints = {
		street nullable: true
		city nullable: true
		postalCode nullable: true
		country nullable: true
	}
}
