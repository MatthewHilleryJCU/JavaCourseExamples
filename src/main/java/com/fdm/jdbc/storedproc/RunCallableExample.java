package com.fdm.jdbc.storedproc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class RunCallableExample {
	public static void main(String[] args) throws SQLException {
		
		DriverManager.registerDriver(new OracleDriver());
		
		Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"Trainee1",
				"!QAZSE4"
		);
		
		UserDao dao = new UserDao(connection);
		FDMUser user = new FDMUser(3, "ashok");
		FDMUser newUser = new FDMUser(3, "matt");
		
		
//		dao.addUser(user);
		
//		dao.removeUser(user.getId());
		
//		dao.updateUser(newUser);
		
		FDMUser dbUser = dao.getUser(user.getId());
		System.out.println(dbUser);
		
	}
}
