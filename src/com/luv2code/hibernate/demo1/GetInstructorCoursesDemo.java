package com.luv2code.hibernate.demo1;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo1.entity.Course;
import com.luv2code.hibernate.demo1.entity.Instructor;
import com.luv2code.hibernate.demo1.entity.InstructorDetail;

public class GetInstructorCoursesDemo 
{
	public static void main(String[] args) {
	              SessionFactory factory = new Configuration()
		                       	.configure("hibernate.cfg.xml")
			                    .addAnnotatedClass(Instructor.class)
			
			                    .addAnnotatedClass(InstructorDetail.class)
			                    .addAnnotatedClass(Course.class)
			
		                   	    .buildSessionFactory();

// create session
             Session session = factory.getCurrentSession();

     try {			


                           session.beginTransaction();
                           int theId=1;
                           Instructor tempInstructor=session.get(Instructor.class,theId);
                           

               		     	System.out.println("Instructor: " + tempInstructor);
  
                            System.out.println("Courses:" +tempInstructor.getCourses() );
//                           List<Course>Courses=;
//                           for(Course c:Courses)
//                           {
//                        	   System.out.println(c);
//                           }
//                        	   
                       
                           session.getTransaction().commit();

         }
         finally 
          {
        	       session.close();
                   factory.close();
          }



     
}
}
