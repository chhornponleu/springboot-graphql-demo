package com.ponleu.graphql.repositoies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ponleu.graphql.models.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

}
