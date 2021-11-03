package com.okan.awssqsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AwsSQSDemoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(AwsSQSDemoApplication.class, args);
	}
}
