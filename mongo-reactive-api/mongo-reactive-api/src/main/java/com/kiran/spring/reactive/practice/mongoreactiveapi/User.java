package com.kiran.spring.reactive.practice.mongoreactiveapi;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	private String id;
	private String name;

	public User() {
	}

	public User(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
