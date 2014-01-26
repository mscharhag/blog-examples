package com.mscharhag.views


class ViewTests extends GroovyTestCase {

	void testViews() {
		Address mikesAddress = new Address(country: 'germany')
		User mike = new User(name: 'mike', address: mikesAddress)
		mike.save(failOnError: true)

		assert UserWithCountry.count() == 1
		UserWithCountry mikeFromGermany = UserWithCountry.get(mike.id)
		assert mikeFromGermany.name == 'mike'
		assert mikeFromGermany.country == 'germany'
	}
}
