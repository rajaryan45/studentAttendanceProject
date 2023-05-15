package com.action.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseServlet;

import teacher.info.Teacher;

@WebServlet("/TeacherData")
public class TeacherData extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResultSet rSet = null;
		String jsonData = null;
		try {
			int teacherId = Integer.parseInt(req.getParameter("teacher_id"));
			System.out.println("Teacher Id : " +  teacherId);
			teacher.setTeacherId(teacherId);
			rSet = dao.getTeacherData(teacher);
			while(rSet.next()) {
				System.out.println("inside");
				Teacher objTeacher = new Teacher(rSet);
				
				jsonData = gson.toJson(objTeacher);
			}
			PrintWriter printWriter = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			printWriter.write(jsonData);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
