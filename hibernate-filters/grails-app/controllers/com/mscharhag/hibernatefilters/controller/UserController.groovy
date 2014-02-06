package com.mscharhag.hibernatefilters.controller

import com.mscharhag.hibernatefilters.domain.Image
import com.mscharhag.hibernatefilters.domain.User

class UserController {

	private User createUser(String username, String email, boolean locked = false) {
		User user = new User(username: username, email: email, locked: locked)
		user.images = new HashSet<>()
		3.times {
			user.images << new Image(user: user, visible: it > 1)
		}
		user.save(failOnError: true, flush: true)
		return user
	}


	/*

	select this_.id as id0_0_, this_.version as version0_0_, this_.email as email0_0_, this_.locked as locked0_0_, this_.username as username0_0_
	from user this_ where this_.locked=0 and this_.username=? limit ?

	select images0_.user_images_id as user1_0_0_, images0_.image_id as image2_0_, images0_.images_idx as images3_0_
	from user_image images0_ where images0_.visible=1 and images0_.user_images_id=?

	 */

	def test() {
		User paul = createUser('Paul', 'paul@test.com')
		User john = createUser('John', 'john@test.com', true)
	}


	def query() {

		User paul = User.findByUsername('Paul')
		println "users: " + User.findAll()
		println 'Paul ' + paul
		User.withoutHibernateFilter('lockedFilter') {
			println 'John ' + User.findByUsername('John')
			println 'Pauls images: ' + paul.images
		}

	}
}
