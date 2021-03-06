package com.app.repo;

import java.util.List;

import org.hibernate.Session;

import com.app.entity.Course;
import com.app.entity.Student;
import com.app.utility.HibernateUtility;

public class StudentCourseRepoImpl implements StudentCourseRepo {

	private Boolean flag = Boolean.FALSE;

	public Boolean saveOrUpdate(Student student) {
		Session session = HibernateUtility.getSession().openSession();
		session.saveOrUpdate(student);
		session.beginTransaction().commit();
		flag = Boolean.TRUE;
		return flag;
	}

	public Course findByCourseId(Integer id) {
		return (Course) HibernateUtility.getSession().openSession().get(Course.class, id);
	}

	public Student findByStudentId(Integer id) {
		return (Student) HibernateUtility.getSession().openSession().get(Student.class, id);
	}

	public Boolean deleteStudent(Integer id) {
		Session session = HibernateUtility.getSession().openSession();
		session.delete((Student) session.get(Student.class, id));
		session.beginTransaction().commit();
		flag = Boolean.TRUE;
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAllStudents() {
		return HibernateUtility.getSession().openSession().createCriteria(Student.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Course> findAllCourses() {
		return HibernateUtility.getSession().openSession().createCriteria(Course.class).list();
	}

}
