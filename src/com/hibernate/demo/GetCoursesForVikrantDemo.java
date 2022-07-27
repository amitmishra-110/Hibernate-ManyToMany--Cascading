package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Course;
import com.jdbc.hibernate.entity.Instructor;
import com.jdbc.hibernate.entity.InstructorDetail;
import com.jdbc.hibernate.entity.Review;
import com.jdbc.hibernate.entity.Student;


//retreiving   student and adding  multiple courses

public class GetCoursesForVikrantDemo {

	public static void main(String[] args) 
	{
			
		//Create SessionFactory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create Session
		Session  session=factory.getCurrentSession();
		
		try
		{
		
			//start a transaction
			session.beginTransaction();

			//ManyToMany Example
			
			
			
			int getId=1;
			
			//get student(vikrant) from db
			
			Student vikrant=session.get(Student.class,getId);
			System.out.println("Loaded Student :" + "  " +vikrant.getCourses());
		
		
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			session.close();
			factory.close();
		}
		finally
		{
			session.close();
			factory.close();
		}
	}
	

	}
