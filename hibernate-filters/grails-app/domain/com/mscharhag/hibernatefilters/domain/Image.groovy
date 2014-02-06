package com.mscharhag.hibernatefilters.domain

class Image {
	boolean visible
	static belongsTo = [user: User]
}
