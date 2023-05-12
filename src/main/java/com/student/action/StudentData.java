package com.student.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.DatabaseDao;
import student.info.Student;

@WebServlet("/StudentData")
public class StudentData extends HttpServlet {
	private Student student = new Student();
	private DatabaseDao dao = new DatabaseDao();
	private ResultSet rSet = null;
	private Gson gson = new Gson();
	private String jsonData = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int admId = Integer.parseInt(request.getParameter("addmissionId"));
		System.out.println("admission ID : " + admId);
		try {
			student.setStudentAdmnId(admId);
			rSet = dao.getStudentData(student);
			System.out.println("out");
			while (rSet.next()) {
				System.out.println("inside");
				Student objStudent = new Student(rSet);
				jsonData = gson.toJson(objStudent);
			}
			PrintWriter printWriter = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			printWriter.write(jsonData);
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
