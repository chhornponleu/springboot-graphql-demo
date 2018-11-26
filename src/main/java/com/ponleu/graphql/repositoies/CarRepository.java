package com.ponleu.graphql.repositoies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ponleu.graphql.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
	
	List<Car> findByNameContains(String name);
	
}
