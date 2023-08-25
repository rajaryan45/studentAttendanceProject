package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import student.info.Student;
import teacher.info.Teacher;

public class DatabaseDao {
	private static final String USER_NAME = "root";
	private static final String PSWD = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/school";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	protected Connection connection = null;
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER_NAME, PSWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
	}
}
