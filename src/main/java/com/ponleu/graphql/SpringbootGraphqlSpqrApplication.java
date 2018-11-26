package com.ponleu.graphql;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ponleu.graphql.models.Car;
import com.ponleu.graphql.models.Model;
import com.ponleu.graphql.repositoies.ModelRepository;
import com.ponleu.graphql.srevices.CarService;

@SpringBootApplication
public class SpringbootGraphqlSpqrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGraphqlSpqrApplication.class, args);

	}

	@Bean
	ApplicationRunner init(CarService carService, ModelRepository modelRepository) {
		return args -> {
			Model model = new Model();
			model.setModel("Toyota");
			model.setDescription("A toyota car");
			model.setYear(2011);
			modelRepository.save(model);

			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti", "AMC Gremlin", "Triumph Stag",
					"Ford Pinto", "Yugo GV").forEach(name -> {
						Car car = new Car();
						car.setName(name);
						car.setModel(model);
						carService.saveCar(car);
						
					});
			carService.getCars().forEach(System.out::println);
		};
	}
}
