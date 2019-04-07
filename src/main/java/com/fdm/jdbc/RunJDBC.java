package com.fdm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class RunJDBC {

	public static void main(String[] args) {
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			Connection connection;
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"Trainee1", 
					"!QAZSE4");
			
			JDBCExample jdbc = new JDBCExample(connection);
			jdbc.printAllUsers();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
