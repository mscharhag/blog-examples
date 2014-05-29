package com.mscharhag.springjooq.jooq;

import org.jooq.DSLContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.*;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class JooqJpaRepositoryFactory extends JpaRepositoryFactory {

	private DSLContext jooq;

	public JooqJpaRepositoryFactory(EntityManager entityManager, DSLContext jooq) {
		super(entityManager);
		this.jooq = jooq;
	}


	protected <T, ID extends Serializable> JpaRepository<?, ?> getTargetRepository(
			RepositoryMetadata metadata, EntityManager entityManager) {

		Class<?> repositoryInterface = metadata.getRepositoryInterface();
		JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());

		SimpleJpaRepository<?, ?> repo;
		if (JooqQueryExecutor.class.isAssignableFrom(repositoryInterface)) {
			repo = new JooqJpaRepository(entityInformation, entityManager, jooq);
		} else {
			repo = new SimpleJpaRepository(entityInformation, entityManager);
		}
		repo.setLockMetadataProvider(LockModeRepositoryPostProcessor.INSTANCE.getLockMetadataProvider());
		return repo;
	}

	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {

		if (JooqQueryExecutor.class.isAssignableFrom(metadata.getRepositoryInterface())) {
			return JooqJpaRepository.class;
		} else {
			return SimpleJpaRepository.class;
		}
	}
}
