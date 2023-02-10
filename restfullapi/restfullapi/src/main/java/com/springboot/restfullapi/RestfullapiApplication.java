package com.springboot.restfullapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfullapiApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(RestfullapiApplication.class, args);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

}
