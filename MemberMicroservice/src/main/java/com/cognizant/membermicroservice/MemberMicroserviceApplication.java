package com.cognizant.membermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
@ComponentScan({"com.cognizant.membermicroservice"})
public class MemberMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberMicroserviceApplication.class, args);
		
	}

}
