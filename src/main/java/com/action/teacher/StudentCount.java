package com.action.teacher;

import java.io.IOException;

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
