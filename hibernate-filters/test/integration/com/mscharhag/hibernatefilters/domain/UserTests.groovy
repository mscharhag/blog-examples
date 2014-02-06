package com.mscharhag.hibernatefilters.domain

import org.grails.plugin.hibernate.filter.DefaultHibernateFiltersHolder
import org.junit.Before

class UserTests extends GroovyTestCase {

	def sessionFactory

	private User createUser(String username, String email, boolean locked = false) {
		User user = new User(username: username, email: email, locked: locked)
		user.save(failOnError: true, flush: true)
		println "created user " + username
		return user
	}

	public void testFindAll() {
		def session = sessionFactory.currentSession
		for (String name in DefaultHibernateFiltersHolder.defaultFilters) {
			session.enableFilter name
		}

		User paul = createUser('Paul', 'paul@test.com')
		User john = createUser('John', 'john@test.com', true)

		List users = User.findAll()

		def p = User.findByUsername('Paul')
		def j = User.findByUsername('John')
		assert p != null
		assert j != null
		assert users == [paul, john]
	}
}
