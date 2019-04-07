package com.fdm.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
	private Connection connection;

	public JDBCExample(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public void createTable() {
		try {
			Statement statement = connection.createStatement();
			String query = "CREATE TABLE FDM_USERS ( U_ID NUMBER (6) PRIMARY KEY, NAME VARCHAR2 (20) )";
			statement.execute(query);
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printAllUsers(String whereClause) {
		try {
			String query = "SELECT U_ID, NAME FROM FDM_USERS where name=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, whereClause);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				int id = resultSet.getInt("U_ID");
				String name = resultSet.getString("NAME");
				System.out.println("Found row : UID="+id+" name="+name);
				
			}
			resultSet.close();
			statement.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
