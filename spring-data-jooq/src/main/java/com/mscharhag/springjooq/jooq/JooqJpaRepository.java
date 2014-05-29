package com.mscharhag.springjooq.jooq;

import com.mscharhag.springjooq.generated.tables.Product;
import com.mscharhag.springjooq.generated.tables.records.ProductRecord;
import org.jooq.DSLContext;
import org.jooq.ResultQuery;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class JooqJpaRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements JooqQueryExecutor<T> {

	private DSLContext jooq;
	private JpaEntityInformation<T, ?> entityInformation;

	public JooqJpaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager, DSLContext jooq) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.jooq = jooq;
	}


	@Override
	public T findOne(ResultQuery q) {
		Class<T> type = entityInformation.getJavaType();
		return q.fetchOne().into(type);
	}

}
