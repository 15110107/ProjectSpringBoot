package com.javatpoint.Artifact.springbootrestexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtifactSpringBootRestExampleApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ArtifactSpringBootRestExampleApplication.class, args);
		} catch(Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

}
