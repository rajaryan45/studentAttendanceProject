package com.action.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseServlet;
import com.google.gson.Gson;

import database.DatabaseDao;
import student.info.Student;

@WebServlet("/StudentData")
public class StudentData extends BaseServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int admId = Integer.parseInt(request.getParameter("addmissionId"));
		System.out.println("admission ID : " + admId);
		try {
			student.setStudentAdmnId(admId);
			rSet = dao.getStudentData(student);
			System.out.println("out");
			PrintWriter printWriter = response.getWriter();
			if(rSet == null) {
				printWriter.write("addmission Id : " + admId + " not present");
			}else {
				 if(rSet.next()) {
					System.out.println("inside");
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
