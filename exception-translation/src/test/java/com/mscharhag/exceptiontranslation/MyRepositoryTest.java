package com.mscharhag.exceptiontranslation;

import com.mscharhag.exceptiontranslation.exception.DataAccessException;
import com.mscharhag.exceptiontranslation.repository.MyRepository;
import org.junit.Test;

public class MyRepositoryTest {

	private MyRepository repository = new MyRepository();

	@Test(expected = DataAccessException.class)
	public void testExceptionTranslation() {
		this.repository.getSomeData();
	}
}
