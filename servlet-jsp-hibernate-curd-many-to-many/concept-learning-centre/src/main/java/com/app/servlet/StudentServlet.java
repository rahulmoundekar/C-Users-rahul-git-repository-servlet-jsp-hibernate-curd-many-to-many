package com.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.entity.Course;
import com.app.entity.Student;
import com.app.service.StudentCourseService;
import com.app.service.impl.StudentCourseServiceImpl;

public class StudentServlet extends HttpServlet {

	private StudentCourseService studentCourseService;

	public StudentServlet() {
		studentCourseService = new StudentCourseServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("courses", studentCourseService.findAllCourses());
		req.setAttribute("students", studentCourseService.findAllStudents());
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = new Student();

		String sid = request.getParameter("id");
		Integer id = Integer.parseInt(sid);
		if (id != null)
			student.setId(id);

		student.setName(request.getParameter("name"));

		String[] courses = request.getParameterValues("courses");

		List<Course> cList = new ArrayList<Course>();

		for (String cid : courses) {
			Course course = new Course();
			course.setId(Integer.parseInt(cid));
			cList.add(course);
		}
		student.setCourses(cList);
		Boolean flag = studentCourseService.saveOrUpdate(student);
		if (flag) {
			request.setAttribute("success", "Student Saved successfully");
		} else {
			request.setAttribute("error", "Student not saved try again..!!");
		}
		request.setAttribute("courses", studentCourseService.findAllCourses());
		request.setAttribute("students", studentCourseService.findAllStudents());
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

}
