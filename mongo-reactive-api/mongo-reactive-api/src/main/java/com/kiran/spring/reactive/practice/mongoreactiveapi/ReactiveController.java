package com.kiran.spring.reactive.practice.mongoreactiveapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive/user")
public class ReactiveController {

	@Autowired
	private UserRepo repo;

	@GetMapping()
	public Flux<User> getUser() {
		return repo.getUsers();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<User> saveUser(@RequestBody User user) {
		return repo.saveUser(user);
	}

	@GetMapping("/{id}")
	public Mono<User> getById(@PathVariable("id") String id) {
		return repo.getUser(id);
	}
}
