package com.mscharhag.archunit;

import java.security.SecureRandom;

public class DemoUtil {

    public static int randomInt() {
        return new SecureRandom().nextInt();
    }
}
