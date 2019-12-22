package com.kiran.practice.microprofile.micro.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariDataSource;

@ApplicationScoped
public class PostDao {
	
	private Logger logger =LoggerFactory.getLogger(PostDao.class);

	@Inject
	DataSource dataSource;
	

	@Inject
	HikariDataSource hkDataSource;

	public String fetchTopRecord() {
		logger.info("Datasource type : {} ",dataSource.getClass().getCanonicalName());
		String result = "";
		try (Connection connection = dataSource.getConnection()) {
			connection.setAutoCommit(false);

			PreparedStatement statement = connection
					.prepareStatement("SELECT POST_ID,TITLE,VERSION FROM PUBLIC.POST ORDER BY POST_ID DESC LIMIT ?");
			ResultSet resultSet = null;
			try {
				statement.setInt(1, 1);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					result = resultSet.getString(2);
					logger.debug("Result set : {}" ,result);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Executed query succesfully using data source object.");
		return result;
	}


	public String fetchTopRecordUsingHKDataSource() {
		logger.info("Datasource type : {} ",hkDataSource.getClass().getCanonicalName());
		String result = "";
		try (Connection connection = hkDataSource.getConnection()) {
			connection.setAutoCommit(false);

			PreparedStatement statement = connection
					.prepareStatement("SELECT POST_ID,TITLE,VERSION FROM PUBLIC.POST ORDER BY POST_ID DESC LIMIT ?");
			ResultSet resultSet = null;
			try {
				statement.setInt(1, 1);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					result = resultSet.getString(2);
					logger.debug("Result set : {}" ,result);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Executed query succesfully using data source object.");
		return result;
	}

}
