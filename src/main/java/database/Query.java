package database;

public class Query {
	
	//Query's are Strored here 
	//For Student Operations
	protected static final String SELECT_STUDENT_ADMN_ID = "SELECT * FROM student WHERE student_admn_id = ?";
	protected static final String SELECT_MAX_ROLL_IN_CLASS = "SELECT MAX(student_roll_num) FROM student WHERE student_class = ? AND student_section = ? AND is_deleted = 0";
	protected static final String INSERT_STUDENT = "INSERT INTO `student` (`student_name`, `student_class`, `student_section`, `student_address`, `student_phone_num`, `student_roll_num`, `student_attendance` , `is_deleted`) VALUES(?,?,?,?,?,?,'0','0')";
	
	//For Teacher Operations
	protected static final String SELECT_TEACHER_ID = "SELECT * FROM teacher WHERE teacher_id = ?";
	protected static final String UPDATE_PRESENT_ATTENDANCE_P1 = "UPDATE `school`.`student` SET student_attendance = student_attendance + 1  WHERE `student_roll_num` IN (";
	protected static final String UPDATE_PRESENT_ATTENDANCE_P2 = ")  AND student_class = ? AND student_section = ? AND is_deleted = 0";
	
	protected static final String PARTIAL_DELETE_OPERATION = "UPDATE `school`.`student` SET `is_deleted` = '1' WHERE `student_admn_id` = ?";
	protected static final String GET_ROLL_FROM_ADMNID = "SELECT student_class , student_section , student_roll_num  FROM student WHERE student_admn_id = ?";
	protected static final String UPDATE_ROLL_AFTER_DELETE = "UPDATE `school`.`student` SET `student_roll_num` = student_roll_num - 1 WHERE student_class = ? AND student_section = ? AND is_deleted = 0 AND student_roll_num > ?";	
	
	protected static final String STUDENT_COUNT = "SELECT COUNT(*) FROM student WHERE student_class = ? AND student_section = ? AND is_deleted = 0";
	
}
