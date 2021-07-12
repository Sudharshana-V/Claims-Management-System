package com.cognizant.claimsmicroservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import com.cognizant.claimsmicroservice.repository.ClaimRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
@ComponentScan({"com.cognizant.claimmicroservice"})
public class ClaimsMicroserviceApplication {

	private ClaimRepository claimRepository;

	public ClaimsMicroserviceApplication(ClaimRepository claimRepository) {
		super();
		this.claimRepository = claimRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ClaimsMicroserviceApplication.class, args);
	}

	
}
