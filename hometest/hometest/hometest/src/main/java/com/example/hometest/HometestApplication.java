package com.example.hometest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.hometest.Account" })
@ComponentScan(basePackages = { "com.example.hometest.User" })

public class HometestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HometestApplication.class, args);
	}

}
