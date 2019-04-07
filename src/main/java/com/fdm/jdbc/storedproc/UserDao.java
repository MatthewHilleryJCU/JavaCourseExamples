package com.fdm.jdbc.storedproc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class UserDao {

	private Connection connection;

	public UserDao(Connection connection) {
		this.connection = connection;
	}

	public void addUser(FDMUser user) {
		try (CallableStatement call = connection.prepareCall("{call INSERT_USER(?,?)}")) {

			call.setInt(1, user.getId());
			call.setString(2, user.getName());
			call.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeUser(int id) {
		try (CallableStatement call = connection.prepareCall("{call REMOVE_USER(?)}")) {

			call.setInt(1, id);
			call.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(FDMUser user) {

		try (CallableStatement call = connection.prepareCall("{call UPDATE_USER(?,?)}")) {

			call.setInt(1, user.getId());
			call.setString(2, user.getName());
			call.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public FDMUser getUser(int id) {

		try (CallableStatement call = connection.prepareCall("{call GET_USER(?,?)}")) {

			call.setInt(1, id);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			
			call.execute();
			
			ResultSet rs = ((OracleCallableStatement)call).getCursor(2);
			while (rs.next()) {
				String name = rs.getString("NAME"); 
				return new FDMUser(id, name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
