package com.luv2code.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo1.entity.Course;
import com.luv2code.hibernate.demo1.entity.Instructor;
import com.luv2code.hibernate.demo1.entity.InstructorDetail;

public class CreateInstructorDemo 
{
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			

			
			Instructor tempInstructor = 
					new Instructor("Madhu", "Patel", "madhu@luv2code.com");
//			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.youtube.com",
							"Guitar");		
			// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		session.beginTransaction();

////			//
			System.out.println("Saving instructor: " + tempInstructor	);
			session.save(tempInstructor);					
////			

			session.getTransaction().commit();
////			
			System.out.println("Done!");
			
			
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
