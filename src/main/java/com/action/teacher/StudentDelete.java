package com.action.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.BaseServlet;

@WebServlet("/StudentDelete")
public class StudentDelete extends BaseServlet {
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			student.setStudentAdmnId(Integer.parseInt(req.getParameter("addmission_id")));
		 	boolean status =  dao.deleteStudent(student);
		 	PrintWriter printWriter = resp.getWriter();
		 	if(status) {
		 		printWriter.write("done");
		 	}else {
		 		printWriter.write("error occured while deleting record");
		 	}
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}
