package com.kiran.spring.reactive.practice.mongoreactiveapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface NonReactiveUserRepo extends MongoRepository<User, String> {
	
}
