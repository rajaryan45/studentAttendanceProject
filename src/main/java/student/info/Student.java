package student.info;

import java.sql.ResultSet;

public class Student {
	private int studentAdmnId;
	private String studentName;
	private String studentClass;
	private String studentSection;
	private String studentAddress;
	private String studentPhoneNum;
	private int studentRollNum;
	private int studentAttendance;
	
	public Student() {
		super();
	}
	
	public Student(ResultSet rSet) {
		try {
			this.setStudentAdmnId(Integer.parseInt(rSet.getString("student_admn_id")));
			this.setStudentName(rSet.getString("student_name"));
			this.setStudentClass(rSet.getString("student_class"));
			this.setStudentSection(rSet.getString("student_section"));
			this.setStudentAddress(rSet.getString("student_address"));
			this.setStudentRollNum(Integer.parseInt(rSet.getString("student_roll_num")));
			this.setStudentPhoneNum(rSet.getString("student_phone_num"));
			this.setStudentAttendance(Integer.parseInt(rSet.getString("student_attendance")));
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public int getStudentAttendance() {
		return studentAttendance;
	}

	public void setStudentAttendance(int studentAttendance) {
		this.studentAttendance = studentAttendance;
	}

	public int getStudentAdmnId() {
		return studentAdmnId;
	}
	public void setStudentAdmnId(int studentAdmnId) {
		this.studentAdmnId = studentAdmnId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getStudentSection() {
		return studentSection;
	}
	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentPhoneNum() {
		return studentPhoneNum;
	}
	public void setStudentPhoneNum(String studentPhoneNum) {
		this.studentPhoneNum = studentPhoneNum;
	}
	public int getStudentRollNum() {
		return studentRollNum;
	}
	public void setStudentRollNum(int studentRollNum) {
		this.studentRollNum = studentRollNum;
	}
	
	
}
