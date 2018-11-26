package com.ponleu.graphql.srevices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ponleu.graphql.models.Car;
import com.ponleu.graphql.repositoies.CarRepository;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class CarService {
	private final CarRepository carRepository;

	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@GraphQLQuery(name = "cars")
	public List<Car> getCars() {
		return carRepository.findAll();
	}

	@GraphQLQuery(name = "cars")
	public List<Car> getCars(@GraphQLArgument(name = "name") String name) {
		return carRepository.findByNameContains(name);
	}

	@GraphQLQuery(name = "car")
	public Optional<Car> getCarById(@GraphQLArgument(name = "id") Long id) {
		return carRepository.findById(id);
	}

	@GraphQLMutation(name = "saveCar")
	public Car saveCar(@GraphQLArgument(name = "car") Car car) {
		return carRepository.save(car);
	}

	@GraphQLMutation(name = "deleteCar")
	public void deleteCar(@GraphQLArgument(name = "id") Long id) {
		carRepository.deleteById(id);
	}

}
