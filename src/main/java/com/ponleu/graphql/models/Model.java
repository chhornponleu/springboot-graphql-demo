package com.ponleu.graphql.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@ToString @EqualsAndHashCode
public class Model {
	
	@Id
	@GeneratedValue
	@GraphQLQuery(name = "id", description = "A model's id")
	private Long id;
	
	@GraphQLQuery(name = "model", description = "A model's name")
	private String model;
	
	@GraphQLQuery(name = "description", description = "A model's description")
	private String description;
	
	@GraphQLQuery(name = "year", description = "The release year")
	private Integer year;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	
	
}
