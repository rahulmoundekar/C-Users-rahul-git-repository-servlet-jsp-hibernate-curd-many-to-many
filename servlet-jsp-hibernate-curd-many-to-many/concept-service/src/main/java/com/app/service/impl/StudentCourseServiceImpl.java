package com.app.service.impl;

import java.util.List;

import com.app.entity.Course;
import com.app.entity.Student;
import com.app.repo.StudentCourseRepo;
import com.app.repo.StudentCourseRepoImpl;
import com.app.service.StudentCourseService;

public class StudentCourseServiceImpl implements StudentCourseService, StudentCourseRepo {

	private StudentCourseRepo studentCourseRepo;

	public StudentCourseServiceImpl() {
		studentCourseRepo = new StudentCourseRepoImpl();
	}

	public Boolean saveOrUpdate(Student student) {
		return studentCourseRepo.saveOrUpdate(student);
	}

	public Course findByCourseId(Integer id) {
		return studentCourseRepo.findByCourseId(id);
	}

	public Student findByStudentId(Integer id) {
		return studentCourseRepo.findByStudentId(id);
	}

	public Boolean deleteStudent(Integer id) {
		return studentCourseRepo.deleteStudent(id);
	}

	public List<Student> findAllStudents() {
		return studentCourseRepo.findAllStudents();
	}

	public List<Course> findAllCourses() {
		return studentCourseRepo.findAllCourses();
	}

}
