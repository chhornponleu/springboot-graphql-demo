package com.ponleu.graphql.srevices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ponleu.graphql.models.Car;
import com.ponleu.graphql.repositoies.CarRepository;

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

	
	@GraphQLQuery(name = "car")
	public Optional<Car> getCarById(Long id) {
		return carRepository.findById(id);
	}

	@GraphQLMutation(name = "saveCar")
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	@GraphQLMutation(name = "deleteCar")
	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}

}
