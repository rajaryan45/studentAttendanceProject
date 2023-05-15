package com.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.google.gson.Gson;

import database.DatabaseDao;
import student.info.Student;
import teacher.info.Teacher;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet{
	protected Student student = new Student();
	protected Teacher teacher = new Teacher();
	protected DatabaseDao dao = new DatabaseDao();	
	protected Gson gson = new Gson();
	
		
}
