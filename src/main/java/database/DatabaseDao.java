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

	private Connection getConnection() {
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

	public ResultSet getStudentData(Student obj) throws SQLException {
		ResultSet rSet = null;
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(Query.SELECT_STUDENT_ADMN_ID);
			statement.setInt(1, obj.getStudentAdmnId());
			rSet = statement.executeQuery();
		} catch (Exception e) {
			e.getMessage();
		}
		return rSet;
	}
	
	public ResultSet getTeacherData(Teacher obj) throws SQLException {
		ResultSet rSet = null;
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(Query.SELECT_TEACHER_ID);
			statement.setInt(1, obj.getTeacherId());
			rSet = statement.executeQuery();
		} catch (Exception e) {
			e.getMessage();
		}
		return rSet;
	}
}
