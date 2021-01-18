package com.example.pgtimeouts.repository;

import com.example.pgtimeouts.domain.Person;
import reactor.core.publisher.Mono;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepository extends ReactiveCrudRepository<Person, Integer> {

	@Query("SELECT * FROM person, pg_sleep(60) where id = :id")
	Mono<Person> findSlow(Integer id);

	Mono<Person> findById(Integer id);
}
