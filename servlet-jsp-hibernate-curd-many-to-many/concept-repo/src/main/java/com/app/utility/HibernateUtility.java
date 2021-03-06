package com.app.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.app.entity.Course;
import com.app.entity.Student;

public class HibernateUtility {

	public static SessionFactory getSession() {

		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/manytomany");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Course.class);
		configuration.setProperties(properties);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		StandardServiceRegistry serviceRegistry = builder.build();

		return configuration.buildSessionFactory(serviceRegistry);
	}

}
