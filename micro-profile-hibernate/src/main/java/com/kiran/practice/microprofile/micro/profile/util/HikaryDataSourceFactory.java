package com.kiran.practice.microprofile.micro.profile.util;

import javax.enterprise.inject.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariDataSource;

public class HikaryDataSourceFactory {

	Logger logger = LoggerFactory.getLogger(HikaryDataSourceFactory.class);

	@Produces
	public HikariDataSource createDataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
		ds.setUsername("postgres");
		ds.setPassword("kiran");
		logger.info("Hikari data source created succefully.");
		return ds;
	}

}
