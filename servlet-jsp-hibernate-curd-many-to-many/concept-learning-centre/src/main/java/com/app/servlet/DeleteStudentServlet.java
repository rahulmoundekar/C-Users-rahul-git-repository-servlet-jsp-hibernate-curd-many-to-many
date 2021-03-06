package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.service.StudentCourseService;
import com.app.service.impl.StudentCourseServiceImpl;

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		Integer id = Integer.parseInt(sid);
		StudentCourseService studentCourseService = new StudentCourseServiceImpl();
		Boolean flag = studentCourseService.deleteStudent(id);
		if (flag) {
			request.setAttribute("success", "Student Deleted successfully");
		} else {
			request.setAttribute("error", "Student not Deleted try again..!!");
		}
		request.setAttribute("courses", studentCourseService.findAllCourses());
		request.setAttribute("students", studentCourseService.findAllStudents());
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);

	}

}
