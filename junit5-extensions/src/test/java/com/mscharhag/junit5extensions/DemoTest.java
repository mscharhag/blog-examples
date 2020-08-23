package com.mscharhag.junit5extensions;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestDurationReportExtension.class)
public class DemoTest {

    @Test
    public void fastTest() throws InterruptedException {
        System.out.println("fast test");
        Thread.sleep(5);
    }

    @Test
    public void slowTest() throws InterruptedException {
        System.out.println("slow test");
        Thread.sleep(50);
    }
}
