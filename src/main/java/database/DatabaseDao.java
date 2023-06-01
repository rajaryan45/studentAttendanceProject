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
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
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
		}finally {
			try {
				rSet.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return add;
	}
	
	public boolean updateAttendance(String rollNums ,String classNum ,String section) {
		boolean done = true;		
		try {
			Connection connection = getConnection();			
			PreparedStatement updateStatement = connection.prepareStatement(Query.UPDATE_PRESENT_ATTENDANCE_P1 + rollNums + Query.UPDATE_PRESENT_ATTENDANCE_P2);			
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
		ResultSet rSet = null;
		try {
			connection = getConnection();
			
			String roll = "";
			String classNum = "";
			String section = "";
			PreparedStatement getRollStatement = connection.prepareStatement(Query.GET_ROLL_FROM_ADMNID);
			getRollStatement.setString(1, Integer.toString(objStudent.getStudentAdmnId()));
			rSet = getRollStatement.executeQuery();
			if (rSet.next()) {
				classNum = rSet.getString(1);
				section = rSet.getString(2);
				roll = rSet.getString(3);
			}
			PreparedStatement updateStatement = connection.prepareStatement(Query.PARTIAL_DELETE_OPERATION);
			updateStatement.setString(1, Integer.toString(objStudent.getStudentAdmnId()));
			updateStatement.execute();
			
			PreparedStatement updateRollStatement = connection.prepareStatement(Query.UPDATE_ROLL_AFTER_DELETE);
			updateRollStatement.setString(1, classNum);
			updateRollStatement.setString(2, section);
			updateRollStatement.setString(3, roll);
			updateRollStatement.execute();
		} catch (Exception e) {
			e.getMessage();
			status = false;
		}finally {
			try {
				rSet.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public int countStudent(String classNum ,String section) {
		int count = -1;
		ResultSet rSet = null;
		try {
			connection = getConnection();
			PreparedStatement coutStatement = connection.prepareStatement(Query.STUDENT_COUNT);
			coutStatement.setString(1, classNum);
			coutStatement.setString(2, section);
			rSet = coutStatement.executeQuery();
			if(rSet.next()) {
				count = Integer.parseInt(rSet.getString(1));
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			try {
				rSet.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return count;
	}
}
