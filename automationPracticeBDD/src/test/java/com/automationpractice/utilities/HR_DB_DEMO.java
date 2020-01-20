package com.automationpractice.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

public class HR_DB_DEMO {

	public static void main(String[] args) {
		connection = getConnection();
		List<Map<String, Object>> list = new HR_DB_DEMO().getQueryResultAsMaps("select city from city;");
		
		for ( int index = 0; index < list.size(); index++ ) {
			Map<String, Object> map = list.get(index);
			for ( Entry<String, Object> m : map.entrySet() ) {
				System.out.println(m.getKey() + " - " + m.getValue());
			}
		}
		
	}
	
	private static final Logger logger = Logger.getLogger(DatabaseConnection.class);
	private static Connection connection;
	
	public static void closeDbConnection () {
		if ( connection != null ) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	private static Connection getConnection () {
		Connection connection = null;
		String dbUrl = "database-2.ckajjvtsvcoe.us-east-1.rds.amazonaws.com";
		String dbPort = "5432";
		String dbName = "dvdrental";
		String dbUser = "user";
		String dbPassword = "user";
		
		dbUrl = "jdbc:postgresql://" + dbUrl + ":" + dbPort + "/" + dbName;
		try {
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}
	
	protected String getQueryResult ( String query ) {
		String result = "";
		
		try {
			//statement
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			result = resultSet.next() ? resultSet.getString(1) : "";
			
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	protected List<String> getQueryResultAsList ( String query ) {
		List<String> queryResults = new ArrayList<>();
		String value = "";
		try {
			//statement
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			
			int columns = resultSetMetaData.getColumnCount();
			
			while ( resultSet.next() ) {
				for ( int index = 1; index <= columns; index++ ) {
					value = resultSet.getObject(index).toString();
					queryResults.add(value);
				}
			}
			statement.close();
			resultSet.close();
		} catch ( SQLException e ) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return queryResults;
	}
	
	protected List<Map<String, Object>> getQueryResultAsMaps ( String query ) {
		List<Map<String, Object>> result = new ArrayList<>();
		Map<String, Object> map;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			
			int columns = resultSetMetaData.getColumnCount();
			
			while ( resultSet.next() ) {
				map = new HashMap<String, Object>();
				
				for ( int index = 1; index <= columns; index++ ) {
					String key = resultSetMetaData.getColumnLabel(index);
					Object object = resultSet.getObject(index);
					
					map.put(key, object);
				}
				result.add(map);
			}
			statement.close();
			resultSet.close();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

}
