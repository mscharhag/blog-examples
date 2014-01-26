package com.mscharhag.exceptiontranslation.repository;

import org.hibernate.JDBCException;

public class MyRepository {

	public Object getSomeData() {
		throw new JDBCException("Error", null);
	}
}
