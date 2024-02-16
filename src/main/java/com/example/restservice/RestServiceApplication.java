package com.example.restservice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class RestServiceApplication {

	private static final Log logger = LogFactory.getLog(RestServiceApplication.class);

	public static void main(String[] args) {
		logger.info("home() has been called");
		SpringApplication.run(RestServiceApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
	
	

}
