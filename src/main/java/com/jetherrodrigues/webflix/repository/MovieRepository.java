package com.jetherrodrigues.webflix.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jetherrodrigues.webflix.domain.Movie;

@Repository
public interface MovieRepository extends  MongoRepository<Movie, String>{

}
