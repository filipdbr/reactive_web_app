package com.dexentri.trigger_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class TriggerServiceApplication {

	// url of the receiver service
	private static final String RECEIVER_URL = "http://localhost:8081/startTask";

	public static void main(String[] args) {
		SpringApplication.run(TriggerServiceApplication.class, args);

		// start the counting task by calling the receiver service
		startCounting();
	}

	// this method sends a request to the receiver service to start the counting task
	private static void startCounting() {
		WebClient webClient = WebClient.create();  // create a WebClient instance to send HTTP requests
		webClient.get()
				.uri(RECEIVER_URL)  // specify the receiver service's url
				.retrieve()  // fetch the response from the receiver service
				.bodyToMono(String.class)  // convert the response body to a Mono<String>
				.subscribe(response -> System.out.println("received response: " + response));  // print the response when the task is complete
	}
}