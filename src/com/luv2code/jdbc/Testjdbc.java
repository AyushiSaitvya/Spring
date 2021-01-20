package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class Testjdbc {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hb-03-one-to-many-uni?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		
		try 
		{
			Connection myCon= DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection Successful");
		}
		
		
		catch(Exception exc){
			
			
		}
		

	}

}
