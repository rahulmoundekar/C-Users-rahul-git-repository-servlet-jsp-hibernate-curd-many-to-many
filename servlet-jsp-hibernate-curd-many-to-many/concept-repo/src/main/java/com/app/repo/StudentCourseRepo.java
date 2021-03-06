package com.app.repo;

import java.util.List;
import com.app.entity.Course;
import com.app.entity.Student;

public interface StudentCourseRepo {

	public Boolean saveOrUpdate(Student student);

	public Course findByCourseId(Integer id);

	public Student findByStudentId(Integer id);

	public Boolean deleteStudent(Integer id);

	public List<Student> findAllStudents();

	public List<Course> findAllCourses();

}
