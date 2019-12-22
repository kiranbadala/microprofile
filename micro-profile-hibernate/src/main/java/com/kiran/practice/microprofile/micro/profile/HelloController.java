package com.kiran.practice.microprofile.micro.profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.kiran.practice.microprofile.micro.profile.dao.PostDao;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

	@Inject
	PostDao dao;
	
	@GET
	public String sayHello() {
		return dao.fetchTopRecord();
	}

	public void accessDatabase() {
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "kiran");
		props.setProperty("preparedStatementCacheQueries", "0");
		props.setProperty("preparedStatementCacheSizeMiB", "0");
		try (Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres?loggerLevel=TRACE&loggerFile=dbLog.log", props)) {
			connection.setAutoCommit(false);

			PreparedStatement statement = connection
					.prepareStatement("SELECT POST_ID,TITLE,VERSION FROM PUBLIC.POST ORDER BY POST_ID DESC LIMIT ?");
			ResultSet resultSet = null;
			try {
				statement.setInt(1, 1);
				resultSet = statement.executeQuery();
				while (resultSet.next())
					System.out.println("Result set : " + resultSet.getString(2));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
