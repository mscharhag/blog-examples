package com.mscharhag.springjooq.jooq;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class JooqRepositoryBean<T extends Repository<S, ID>, S, ID extends Serializable>
		extends JpaRepositoryFactoryBean<T, S, ID> {

	@Autowired
	private DSLContext jooq;

	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new JooqJpaRepositoryFactory(entityManager, jooq);
	}
}
