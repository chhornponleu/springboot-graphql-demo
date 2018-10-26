package com.ponleu.graphql.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Car {
	
	@Id @GeneratedValue
	@GraphQLQuery(name = "id", description = "A car's id")
    private Long id;
	
	@GraphQLQuery(name = "name", description = "A car's name")
    private @NonNull String name;

}
