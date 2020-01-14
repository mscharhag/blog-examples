package com.mscharhag.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulDemoApplication.class, args);
	}
}
