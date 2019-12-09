package com.mscharhag.micrometerexample;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.jmx.JmxConfig;
import io.micrometer.jmx.JmxMeterRegistry;

import java.time.Duration;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MeterRegistry registry = new JmxMeterRegistry(new JmxConfig() {
            @Override
            public Duration step() {
                return Duration.ofSeconds(1);
            }

            @Override
            public String get(String s) {
                return null;
            }
        }, Clock.SYSTEM);

        Counter counter = Counter
                .builder("my.counter")
                .description("counts something important")
                .tag("environment", "test")
                .tag("region", "us-east")
                .register(registry);

        counter.increment();
        counter.increment(2.5);

        Timer timer = Timer.builder("my.timer").register(registry);

        timer.record(() -> {
            System.out.println("sleeping");
            try {
                Thread.sleep(550);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        timer.record(Duration.ofMillis(3));

        // Wait some time before application exit
        // This gives some time to use JConsole to connect to the
        // application and inspect the metrics
        System.out.println("Keeping application alive");
        Thread.sleep(240000);
        System.out.println("done");
    }
}
