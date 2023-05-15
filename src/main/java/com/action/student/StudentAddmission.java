package com.action.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseServlet;

import student.info.Student;

@WebServlet("/StudentAddmission")
public class StudentAddmission extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1065434851395295776L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student objStudent = new Student();
		objStudent.setStudentName(req.getParameter("student_name"));
		objStudent.setStudentClass(req.getParameter("student_class"));
		objStudent.setStudentSection(req.getParameter("student_section"));
		objStudent.setStudentAddress(req.getParameter("student_address"));
		objStudent.setStudentPhoneNum(req.getParameter("student_phone_num"));
		try {
			boolean add = dao.addmitStudent(objStudent);
			PrintWriter printWriter = resp.getWriter();
			if (add) {
				printWriter.write("add");
			}else {
				printWriter.write("error in addmission");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}
