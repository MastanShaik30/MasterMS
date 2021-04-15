package com.masterms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/masterPage")
public class MasterController {
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{username}")
	public String getStudents(@PathVariable String username) {
		System.out.println("Getting user details for " + username);
		String response = restTemplate.exchange("http://todo-service/todos/{username}/todos", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
		}, username).getBody();

		System.out.println("Response Received as " + response);

		return "User -  " + username + " \n User Details " + response;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
