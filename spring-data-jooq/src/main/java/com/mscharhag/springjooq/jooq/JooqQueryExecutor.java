package com.mscharhag.springjooq.jooq;

import org.jooq.ResultQuery;

public interface JooqQueryExecutor<T> {

	T findOne(ResultQuery q);
}
