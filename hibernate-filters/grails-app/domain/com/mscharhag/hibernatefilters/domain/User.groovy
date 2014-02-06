package com.mscharhag.hibernatefilters.domain

class User {

	String username
	boolean locked

	static hasMany = [images: Image]

	static hibernateFilters = {
		lockedFilter(condition: 'locked=0', default: true)
		imagesVisibleFilter(collection: 'images', condition: 'visible=1', default: true)
	}
}
