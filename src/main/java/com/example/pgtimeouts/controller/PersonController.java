package com.example.pgtimeouts.controller;

import java.time.Duration;

import com.example.pgtimeouts.domain.Person;
import com.example.pgtimeouts.repository.PersonRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PersonController {

	private final PersonRepository personRepository;

	@GetMapping("/{id}")
	@Transactional(timeout = 1)
	Mono<Person> getPerson(@PathVariable Integer id) {
		return  personRepository.findSlow(id).timeout(Duration.ofSeconds(5));
	}

	@GetMapping("/quick/{id}")
	@Transactional(timeout = 1)
	Mono<Person> getPersonQuick(@PathVariable Integer id) {
		return  personRepository.findById(id).timeout(Duration.ofSeconds(5));
	}
}
