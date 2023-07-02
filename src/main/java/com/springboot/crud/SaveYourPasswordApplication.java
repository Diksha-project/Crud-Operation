package com.springboot.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class SaveYourPasswordApplication {


	public static void main(String[] args) {
		SpringApplication.run(SaveYourPasswordApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();}
}
