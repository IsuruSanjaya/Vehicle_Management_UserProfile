package vehicle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import vehicle.model.User;


public class UserDA {
	private String jdbcURL = "jdbc:mysql://localhost:3306/vehicle?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1234";

	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name,	mobileNo, address, date, vehicleNo, vehicleType) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,name, mobileNo,address,date,vehicleNo,vehicleType from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users where name = ?";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name=?, mobileNo=?, address=?, date=?, vehicleNo=?, vehicleType=?  where id = ?;";
	private String savename;

	public UserDA() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getMobileNo());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getDate());
			preparedStatement.setString(5, user.getVehicleNo());
			preparedStatement.setString(6, user.getVehicleType());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				System.out.println("name:" +rs.getString("name"));
				String name = rs.getString("name");
				String mobileNo = rs.getString("mobileNo");
				String address = rs.getString("address");
				String date = rs.getString("date");
				String vehicleNo = rs.getString("vehicleNo");
				String vehicleType = rs.getString("vehicleType");
				user = new User(id, name, mobileNo,address,date,vehicleNo,vehicleType);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	
	

	


	public List<User> selectAllUsers(String savename) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			preparedStatement.setString(1,savename);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mobileNo = rs.getString("mobileNo");
				String address = rs.getString("address");
				String date = rs.getString("date");
				String vehicleNo = rs.getString("vehicleNo");
				String vehicleType = rs.getString("vehicleType");
				users.add(new User(id, name, mobileNo,address,date, vehicleNo,vehicleType));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getMobileNo());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getDate());
			statement.setString(5, user.getVehicleNo());
			statement.setString(6, user.getVehicleType());
			statement.setInt(7, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
			
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
