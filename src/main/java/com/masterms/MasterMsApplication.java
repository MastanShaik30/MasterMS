package com.masterms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MasterMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterMsApplication.class, args);
	}

}
