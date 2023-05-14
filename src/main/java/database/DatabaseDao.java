package database;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.apache.tomcat.dbcp.pool2.impl.AbandonedConfig;

import student.info.Student;
import teacher.info.Teacher;

public class DatabaseDao {
	private static final String USER_NAME = "root";
	private static final String PSWD = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/school";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private Connection connection = null;
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
		connection = getConnection();
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
		connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(Query.SELECT_TEACHER_ID);
			statement.setInt(1, obj.getTeacherId());
			rSet = statement.executeQuery();
		} catch (Exception e) {
			e.getMessage();
		}
		return rSet;
	}
	
	public boolean addmitStudent(Student obj) {
		boolean add = true;
		ResultSet rSet = null;
		int roll = -1;
		connection = getConnection();
		try {
			PreparedStatement maxRollStmt = connection.prepareStatement(Query.SELECT_MAX_ROLL_IN_CLASS);
			maxRollStmt.setString(1, obj.getStudentClass());
			maxRollStmt.setString(2, obj.getStudentSection());
			rSet = maxRollStmt.executeQuery();
			if(rSet.next()) {
				roll = Integer.parseInt(rSet.getString(1)) + 1;
			}
			System.out.println("roll : " + roll);
			PreparedStatement insertStudent = connection.prepareStatement(Query.INSERT_STUDENT);
			insertStudent.setString(1, obj.getStudentName());
			insertStudent.setString(2, obj.getStudentClass());
			insertStudent.setString(3, obj.getStudentSection());
			insertStudent.setString(4, obj.getStudentAddress());
			insertStudent.setString(5, obj.getStudentPhoneNum());
			insertStudent.setString(6, Integer.toString(roll));
			insertStudent.execute();
			
		}catch (Exception e) {
			e.getMessage();
			add = false;
		}
		return add;
	}
	
	public boolean updateAttendance(String rollNums ,String classNum ,String section) {
		boolean done = true;
		List<String>rollList = Arrays.asList(rollNums.split(","));
		try {
			Connection connection = getConnection();			
			PreparedStatement updateStatement = connection.prepareStatement(Query.UPDATE_ATTENDANCE_P1 + rollNums + Query.UPDATE_ATTENDANCE_P2);			
			updateStatement.setString(1, classNum);
			updateStatement.setString(2, section);
			updateStatement.execute();
		} catch (Exception e) {
			e.getMessage();
			done = false;
		}
		return done;
	}
	
	public boolean deleteStudent(Student objStudent) {
		boolean status = true;
		try {
			connection = getConnection();
			PreparedStatement updateStatement = connection.prepareStatement(Query.PARTIAL_DELETE_OPERATION);
			updateStatement.setString(1, Integer.toString(objStudent.getStudentAdmnId()));
			updateStatement.execute();
		} catch (Exception e) {
			e.getMessage();
			status = false;
		}
		return status;
	}
}
