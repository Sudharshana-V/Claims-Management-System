package com.cognizant.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
@ComponentScan("com.cognizant.policy.*")
public class PolicyDemoApplication 
{
	public static final Logger logger = LoggerFactory.getLogger(PolicyDemoApplication.class);
	public static void main(String[] args) 
	{
		logger.info("this is a info message");
	    logger.warn("this is a warn message");
	    logger.error("this is a error message");
	    logger.debug("this is a debug message");
		SpringApplication.run(PolicyDemoApplication.class, args);
	}
}