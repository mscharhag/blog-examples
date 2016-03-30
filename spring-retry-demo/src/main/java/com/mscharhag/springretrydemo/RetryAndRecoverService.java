package com.mscharhag.springretrydemo;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryAndRecoverService {

    @Retryable(value = {FooException.class, BarException.class}, maxAttempts = 5)
    public void retryWithException() {
        System.out.println("retryWithException");
        throw new FooException();
    }


    @Recover
    public void recover(FooException exception) {
        System.out.println("recovering from " + exception);
    }


    private static class FooException extends RuntimeException {

    }

    private static class BarException extends RuntimeException {

    }
}
