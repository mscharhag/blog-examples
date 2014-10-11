package com.mscharhag.examples.domaininjection;

import com.mscharhag.examples.domaininjection.annotation.LoggedInUser;
import com.mscharhag.examples.domaininjection.annotation.SessionScopedBean;
import com.mscharhag.examples.domaininjection.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.mscharhag.examples.domaininjection"})
public class Application {

//	@Bean
//	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	@LoggedInUser
	@SessionScopedBean
	public User getLoggedInUser() {
		return new User("john", "smith");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
