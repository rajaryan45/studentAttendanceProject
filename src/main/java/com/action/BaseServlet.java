package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.DatabaseDao;
import student.info.Student;
import teacher.info.Teacher;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet{
	protected Student student = new Student();
	protected Teacher teacher = new Teacher();
	protected DatabaseDao dao = new DatabaseDao();
	protected ResultSet rSet = null;
	protected Gson gson = new Gson();
	protected String jsonData = null;
		
}
