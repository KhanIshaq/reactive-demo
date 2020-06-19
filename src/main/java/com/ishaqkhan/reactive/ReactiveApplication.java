package com.ishaqkhan.reactive;

import org.reactivestreams.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}

	@Bean
	CommandLineRunner demo() {
		return args -> {
			
			//Publisher<String> p; //Base Type in Reactive
			//Sub types of Publisher
			//Mono - Is a publisher that will produce only one value
			//Flux - Is a publisher that will produce unlimited values
			Publisher<String> p;
			Flux<String> x = Flux.fromArray("1,2,3,4,5,6,7,8,9,10,11,12".split(","));
			x.map(Integer::parseInt)
			 .filter(i -> i%2 == 0)
			 .subscribe(System.out::println, null, null);
			
			p = x;
		};
	}
}
