package com.mscharhag.springretrydemo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RetryExampleApplication.class)
public class RetryTest {

    @Autowired
    private RetryService retryService;


    @Autowired
    private RetryAndRecoverService retryAndRecoverService;

	@Test
	public void simpleRetry() {
        retryService.simpleRetry();
	}


    @Test
    public void retryWithException() {
        retryAndRecoverService.retryWithException();
    }


	@Test
	public void withTemplate() {
        retryService.withTemplate();
	}
}
