package com.action.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.valves.rewrite.RewriteCond;

import com.action.BaseServlet;
@WebServlet("/StudentSubjects")
public class StudentSubjects extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cls = Integer.parseInt(req.getParameter("classNumber"));
		String sec = req.getParameter("section");
		String subjects = req.getParameter("subjectsName");
		PrintWriter printWriter = resp.getWriter();
		try {
			teacherDao.setStudentSubjectName(cls,sec,subjects);
			printWriter.write("Done");
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage() + " : " );
			e.printStackTrace();
		}
	}
	
}	
