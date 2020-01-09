package com.kiran.spring.reactive.practice.mongoreactiveapi;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.async.client.MongoClientSettings;
import com.mongodb.connection.SslSettings;
import com.mongodb.connection.netty.NettyStreamFactoryFactory;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

public class MongoConnectionTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		User user = new User("nandu", "12");
		MongoClientSettings settings = MongoClientSettings.builder()
				.sslSettings(SslSettings.builder().enabled(true).invalidHostNameAllowed(true).build())
				.streamFactoryFactory(new NettyStreamFactoryFactory())
				.applyConnectionString(new ConnectionString(
						"mongodb+srv://kirru:kirru@reactivepracticecluster-fljxz.mongodb.net/test?retryWrites=true&w=majority"))
				.build();
		MongoClient client = MongoClients.create(settings);
		ReactiveMongoTemplate dataBase = new ReactiveMongoTemplate(client, "test");
		dataBase.insert(user);
		System.out.println("Done.");
	}

}
