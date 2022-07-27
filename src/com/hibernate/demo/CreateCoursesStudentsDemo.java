package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Course;
import com.jdbc.hibernate.entity.Instructor;
import com.jdbc.hibernate.entity.InstructorDetail;
import com.jdbc.hibernate.entity.Review;
import com.jdbc.hibernate.entity.Student;



//creating  multiple courses and adding many  student 
public class CreateCoursesStudentsDemo {

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
			
			//create course
			Course tmpCourse=new Course("cricket");
			
			
			
			//Creating students
			Student tmpStudent=new  Student("Vikrant","Sisodia","vikrant@gmail.com");
			Student tmpStudent2=new Student("Rajesh","Raut","rajesh@gmail.com");
			
			
			//adding student to courses ex:A course can have multiple student
			tmpCourse.addStudents(tmpStudent);
			tmpCourse.addStudents(tmpStudent2);
			
			//saving the students
			session.save(tmpStudent);
			session.save(tmpStudent2);
			
			System.out.println("Saving the Students in the course");
			
			
			
			//save the course
			session.save(tmpCourse);
			System.out.println("Course has been saved");
			
	
			
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
