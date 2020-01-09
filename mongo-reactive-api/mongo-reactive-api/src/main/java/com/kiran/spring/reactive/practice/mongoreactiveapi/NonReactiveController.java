package com.kiran.spring.reactive.practice.mongoreactiveapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/nonreactive/user")
public class NonReactiveController {


	@Autowired
	private NonReactiveUserRepo repo;

	@GetMapping()
	public List<User> getUser() {
		return repo.findAll();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public User saveUser(@RequestBody User user) {
		return repo.save(user);
	}

	@GetMapping("/{id}")
	public Optional<User> getById(@PathVariable("id") String id) {
		return repo.findById(id);
	}

}
