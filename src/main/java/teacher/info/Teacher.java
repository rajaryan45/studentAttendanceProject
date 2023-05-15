package teacher.info;

import java.sql.ResultSet;

public class Teacher {
	private int teacherId;
	private String teacherName;
	private String subject;
	private String dob;
	private String address;
	private String phoneNumber;
	private String currentClass;
	private String currentSection;
	
	public Teacher() {
		super();
	}
	
	public Teacher(ResultSet rset){
		try {
			System.out.println("Teacher");
			this.setTeacherId(Integer.parseInt(rset.getString("teacher_id")));
			this.setTeacherName(rset.getString("teacher_name"));
			System.out.println("teacher name : " + rset.getString("teacher_name"));
			this.setSubject(rset.getString("subject"));
			this.setDob(rset.getString("dob"));
			this.setAddress(rset.getString("address"));
			this.setPhoneNumber(rset.getString("phone_number"));
			this.setCurrentClass(rset.getString("current_class"));
			this.setCurrentSection(rset.getString("current_section"));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCurrentClass() {
		return currentClass;
	}
	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}
	public String getCurrentSection() {
		return currentSection;
	}
	public void setCurrentSection(String currentSection) {
		this.currentSection = currentSection;
	}
	
	
	
}
