package com.action.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseServlet;

@WebServlet("/StudentCount")
public class StudentCount extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2387785322881684429L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String classNum = req.getParameter("class");
		String section = req.getParameter("section");
		PrintWriter printWriter = resp.getWriter();
		try {
			int count = dao.countStudent(classNum, section);
			printWriter.write("count : " + count);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
