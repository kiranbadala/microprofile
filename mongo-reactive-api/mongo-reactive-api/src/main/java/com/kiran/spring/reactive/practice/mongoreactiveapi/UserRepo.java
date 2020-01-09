package com.kiran.spring.reactive.practice.mongoreactiveapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserRepo {

	@Autowired
	ReactiveMongoTemplate mongoDb;
	
	public  Mono<User> saveUser(User user) {
		return mongoDb.insert(user);
	}
	
	public Flux<User> getUsers() {
		return mongoDb.findAll(User.class);
	}
	
	public Mono<User> getUser(String id){
		return mongoDb.findById(id, User.class);
	}
}
