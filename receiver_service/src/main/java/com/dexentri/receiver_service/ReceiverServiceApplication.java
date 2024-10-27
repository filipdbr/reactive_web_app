package com.dexentri.receiver_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@SpringBootApplication
public class ReceiverServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceiverServiceApplication.class, args);
	}
}

@RestController  // this class will handle HTTP requests
class TaskController {

	// this method starts the counting task when an HTTP GET request is received
	@GetMapping("/startTask")
	public Mono<String> startTask() {
		// create a Flux that counts from 0 to 1000, with a 1-second delay between each number
		return Flux.range(0, 1001)
				.delayElements(Duration.ofSeconds(1))  // add a 1-second delay between elements
				.doOnNext(i -> System.out.println("counting: " + i))  // print each number as it is counted
				.then(Mono.just("task completed"));  // once the counting is done, return "task completed"
	}
}
