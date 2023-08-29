package subject;

public class Subject {

	private int marks;
	private String subName;
	
	public Subject(int marks, String subName) {
		super();
		this.marks = marks;
		this.subName = subName;
	}
	public Subject() {
		super();
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	

}
