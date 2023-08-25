package com.action.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseServlet;

import student.info.Student;

@WebServlet("/StudentData")
public class StudentData extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6152205822758810353L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int admId = Integer.parseInt(request.getParameter("addmissionId"));
		System.out.println("admission ID : " + admId);
		ResultSet rSet = null;
		String jsonData = null;
		try {
			student.setStudentAdmnId(admId);
			rSet = studentDao.getStudentData(student);
			System.out.println("out");
			PrintWriter printWriter = response.getWriter();
			if(rSet == null) {
				printWriter.write("addmission Id : " + admId + " not present");
			}else {
				 if(rSet.next()) {					
					Student objStudent = new Student(rSet);
					jsonData = gson.toJson(objStudent);
				}else {
					printWriter.write("addmission Id : " + admId + " not present");
				}
			}						
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			if(jsonData != null)
				printWriter.write(jsonData);
			
		} catch (Exception e) {
			e.getMessage();
		}finally {
			try {
				rSet.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}

	}

}
