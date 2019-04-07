package com.fdm.jdbc.storedproc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import oracle.jdbc.OracleCallableStatement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserDaoTest {

	private FDMUser user = mock(FDMUser.class);
	private OracleCallableStatement callable = mock(OracleCallableStatement.class);
	private Connection connection = mock(Connection.class);
	private ResultSet rs = mock(ResultSet.class);

	private UserDao userDao = new UserDao(connection);

	@Test
	public void executes_callable_statement_with_credentials_from_user() throws SQLException {
		when(user.getName()).thenReturn("Matt");
		when(user.getId()).thenReturn(101);
		when(connection.prepareCall("{call INSERT_USER(?,?)}")).thenReturn(callable);

		userDao.addUser(user);

		verify(callable).setInt(1, 101);
		verify(callable).setString(2, "Matt");
		verify(callable).executeUpdate();
		verify(callable).close();

	}

	@Test
	public void throws_error_when_executes_callable_statement_with_credentials_from_user() throws SQLException {

		when(connection.prepareCall("{call INSERT_USER(?,?)}")).thenReturn(callable);

		SQLException sqle = mock(SQLException.class);

		doThrow(sqle).when(connection).prepareCall("{call INSERT_USER(?,?)}");

		userDao.addUser(user);

		verify(sqle).printStackTrace();

	}

	@Test
	public void executes_callable_statement_removing_user_row_using_id() throws SQLException {
		when(user.getId()).thenReturn(101);
		when(connection.prepareCall("{call REMOVE_USER(?)}")).thenReturn(callable);

		userDao.removeUser(user.getId());

		verify(callable).setInt(1, 101);
		verify(callable).executeUpdate();
		verify(callable).close();

	}

	@Test
	public void throws_error_when_executes_callable_statement_removing_user_row_using_id() throws SQLException {

		when(connection.prepareCall("{call REMOVE_USER(?)}")).thenReturn(callable);

		SQLException sqle = mock(SQLException.class);
		doThrow(sqle).when(connection).prepareCall("{call REMOVE_USER(?)}");

		userDao.removeUser(user.getId());

		verify(sqle).printStackTrace();
	}

	@Test
	public void executes_callable_statement_updating_username_using_id() throws SQLException {
		when(user.getId()).thenReturn(101);
		when(user.getName()).thenReturn("Matt");

		when(connection.prepareCall("{call UPDATE_USER(?,?)}")).thenReturn(callable);

		userDao.updateUser(user);

		verify(callable).setInt(1, 101);
		verify(callable).setString(2, "Matt");
		verify(callable).executeUpdate();
		verify(callable).close();

	}

	@Test
	public void throws_error_when_executes_callable_statement_updating_user_row_using_id() throws SQLException {

		when(connection.prepareCall("{call UPDATE_USER(?,?)}")).thenReturn(callable);

		SQLException sqle = mock(SQLException.class);
		doThrow(sqle).when(connection).prepareCall("{call UPDATE_USER(?,?)}");

		userDao.updateUser(user);

		verify(sqle).printStackTrace();
	}

	@Test
	public void executes_callable_statement_getting_user_using_id() throws SQLException {
		when(connection.prepareCall("{call GET_USER(?,?)}")).thenReturn(callable);
		when(callable.getCursor(2)).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("NAME")).thenReturn("Matt");

		FDMUser user = userDao.getUser(101);

		verify(callable).setInt(1, 101);
		verify(callable).execute();
		verify(callable).close();
		assertEquals("Matt", user.getName());
		assertEquals(101, user.getId());
	}

	@Test
	public void throws_error_when_executes_callable_statement_getting_user_using_id() throws SQLException {

		when(connection.prepareCall("{call GET_USER(?,?)}")).thenReturn(callable);

		SQLException sqle = mock(SQLException.class);
		doThrow(sqle).when(connection).prepareCall("{call GET_USER(?,?)}");

		userDao.getUser(101);

		verify(sqle).printStackTrace();
	}
}
