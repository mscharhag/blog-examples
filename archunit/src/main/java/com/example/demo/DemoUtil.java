package com.example.demo;

import java.security.SecureRandom;

public class DemoUtil {

    public static int randomInt() {
        return new SecureRandom().nextInt();
    }
}
