package com.mscharhag.examples.domaininjection.controller;

import com.mscharhag.examples.domaininjection.annotation.LoggedInUser;
import com.mscharhag.examples.domaininjection.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	@LoggedInUser
	private User loggedInUser;

	@RequestMapping("/test")
	public String workWithUser() {
		return "user: " + loggedInUser;
	}

}
