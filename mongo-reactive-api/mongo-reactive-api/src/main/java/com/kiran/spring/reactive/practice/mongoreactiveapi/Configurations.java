package com.kiran.spring.reactive.practice.mongoreactiveapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.async.client.MongoClientSettings;
import com.mongodb.connection.SslSettings;
import com.mongodb.connection.netty.NettyStreamFactoryFactory;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
public class Configurations {

	@SuppressWarnings("deprecation")
	public @Bean MongoClient reactiveMongoClient() {
		MongoClientSettings settings = MongoClientSettings.builder()
				.sslSettings(SslSettings.builder().enabled(true).invalidHostNameAllowed(true).build())
				.streamFactoryFactory(new NettyStreamFactoryFactory())
				.applyConnectionString(new ConnectionString(
						"mongodb+srv://kirru:kirru@reactivepracticecluster-fljxz.mongodb.net/test?retryWrites=true&w=majority"))
				.build();
		return MongoClients.create(settings);
	}

	public @Bean ReactiveMongoTemplate reactiveMongoTemplate() {
		return new ReactiveMongoTemplate(reactiveMongoClient(), "test");
	}
}
