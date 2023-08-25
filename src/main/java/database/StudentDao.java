package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import student.info.Student;

public class StudentDao extends DatabaseDao{

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
}
