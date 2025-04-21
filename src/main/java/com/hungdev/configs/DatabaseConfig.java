package com.hungdev.configs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig {
	@Autowired
	private Environment env;
	
	private HikariDataSource hikariDataSource;
	
	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		config.setJdbcUrl(env.getProperty("spring.datasource.url"));
		config.setUsername(env.getProperty("spring.datasource.username"));
		config.setPassword(env.getProperty("spring.datasource.password"));

		config.setMaximumPoolSize(10);
		config.setMinimumIdle(2);
		config.setIdleTimeout(30000);
		config.setMaxLifetime(1800000);

		hikariDataSource = new HikariDataSource(config);
		return hikariDataSource;
	}

	public Connection getConnection() throws SQLException {
		return hikariDataSource.getConnection();
	}

	public void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * public static void main(String[] args) { DatabaseConfig dbConfig = new
	 * DatabaseConfig(); try { Connection conn = dbConfig.getConnection();
	 * 
	 * String sql = "SELECT FullName FROM Student"; PreparedStatement stmt =
	 * conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery();
	 * 
	 * System.out.println("List of students:"); while (rs.next()) { String fullName
	 * = rs.getString("FullName"); System.out.println("- " + fullName); }
	 * 
	 * dbConfig.closeConnection(conn); } catch (Exception e) { e.printStackTrace();
	 * } }
	 */
}
