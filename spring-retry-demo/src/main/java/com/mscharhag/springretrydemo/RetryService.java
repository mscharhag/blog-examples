package com.mscharhag.springretrydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

    @Autowired
    private RetryTemplate retryTemplate;


    @Retryable
    public void simpleRetry() {
        System.out.println("simpleRetry");
        throw new IllegalStateException("Something went wrong");
    }


    public void withTemplate() {
        retryTemplate.execute(context -> {
            System.out.println("withTemplate");
            throw new IllegalStateException("Something went wrong");
        });
    }

}
