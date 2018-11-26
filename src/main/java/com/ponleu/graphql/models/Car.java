package com.ponleu.graphql.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode
public class Car {

	@Id
	@GeneratedValue
	@GraphQLQuery(name = "id", description = "A car's id")
	private Long id;

	@GraphQLQuery(name = "name", description = "A car's name")
	private @NonNull String name;

	@ManyToOne
	@JoinColumn(name = "model_id")
	@GraphQLQuery(name = "model", description = "A car's name")
	private Model model;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	
	
	
}
