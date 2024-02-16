package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	WebClient webClient = WebClient.create(); 


	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		WebClient.ResponseSpec responseSpec = webClient.get()
			    .uri("http://localhost:8082/ingreeting")
			    .retrieve();
		
		String responseBody = responseSpec.bodyToMono(String.class).block();
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
