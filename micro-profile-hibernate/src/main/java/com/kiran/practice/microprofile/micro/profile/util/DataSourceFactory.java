package com.kiran.practice.microprofile.micro.profile.util;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceFactory {
	Logger logger = LoggerFactory.getLogger(DataSourceFactory.class); 
	
	@Produces
	@Alternative
	public DataSource createDataSource() {
		PGSimpleDataSource dataSource =  new PGSimpleDataSource();
		dataSource.setDatabaseName("postgres");
		dataSource.setServerName("localhost");
		dataSource.setUser("postgres");
		dataSource.setPassword("kiran");
		logger.info("Datasource created succefuly.");
		return dataSource;
	}
}
