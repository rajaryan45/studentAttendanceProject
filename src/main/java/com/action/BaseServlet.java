package com.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.google.gson.Gson;

import database.DatabaseDao;
import database.StudentDao;
import database.TeacherDao;
import student.info.Student;
import teacher.info.Teacher;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6515993552987712804L;
	protected Student student = new Student();
	protected Teacher teacher = new Teacher();
	protected DatabaseDao databaseDao = new DatabaseDao();
	protected StudentDao studentDao = new StudentDao();
	protected TeacherDao teacherDao = new TeacherDao();
	protected Gson gson = new Gson();
	
		
}
