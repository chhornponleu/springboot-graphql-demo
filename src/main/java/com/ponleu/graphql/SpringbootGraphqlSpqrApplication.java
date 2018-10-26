package com.ponleu.graphql;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ponleu.graphql.models.Car;
import com.ponleu.graphql.srevices.CarService;

@SpringBootApplication
public class SpringbootGraphqlSpqrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGraphqlSpqrApplication.class, args);

	}

	@Bean
	ApplicationRunner init(CarService carService) {
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti", "AMC Gremlin", "Triumph Stag",
					"Ford Pinto", "Yugo GV").forEach(name -> {
						Car car = new Car();
						car.setName(name);
						carService.saveCar(car);
					});
			carService.getCars().forEach(System.out::println);
		};
	}
}
