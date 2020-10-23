package com.ibm.mccf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
public class MCCFApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(MCCFApplication.class, args);
	}
	
}
