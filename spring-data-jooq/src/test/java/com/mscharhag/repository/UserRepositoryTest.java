package com.mscharhag.repository;

import com.mscharhag.springjooq.Application;
import com.mscharhag.springjooq.entity.User;
import com.mscharhag.springjooq.generated.tables.Product;
import com.mscharhag.springjooq.repository.UserRepository;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static com.mscharhag.springjooq.generated.tables.User.USER;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
//@Transactional
//@TransactionConfiguration(defaultRollback = true)
public class UserRepositoryTest {

	@Autowired
	DSLContext jooq;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AnnotationConfigApplicationContext applicationContext;

	@Test
	public void test() {

//		User user = new User();
//		user.setEmail("foo@bar.de");
//		user.setName("jim");
//		userRepository.save(user);

		User userFromFinder = userRepository.findUserByName("jim");
		System.out.println("userFromFinder: " + userFromFinder);

		User userFromJooq = userRepository.findOne(jooq.selectFrom(USER)
				.where(USER.NAME.equal("jim")));


		System.out.println("userFromJooq: " + userFromJooq);
	}
}
