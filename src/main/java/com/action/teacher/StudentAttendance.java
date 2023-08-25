package com.action.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseServlet;

@WebServlet("/StudentAttendance")
public class StudentAttendance extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6980137331061777409L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rollNumString = req.getParameter("roll_num");
		String classNum = req.getParameter("class");
		String section = req.getParameter("section");
		try {
			
			boolean status = teacherDao.updateAttendance(rollNumString, classNum, section);
			PrintWriter printWriter = resp.getWriter();
			if(status) {
				printWriter.write("attendace update for Class : " + classNum + " Section : " + section );
			}else {
				printWriter.write("error occured while updating attendance for Class : " + classNum + " Section : " + section );
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
