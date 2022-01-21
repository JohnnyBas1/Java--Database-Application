




package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cours_Methods {
	
	public static void createTable() throws SQLException
	{
		Connection connection = null;
		PreparedStatement prepstate = null;
		
		try {
			connection = Connect.getConnection();
			 prepstate = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Courses (courseID"
			 		+ " varchar(30) NOT NULL, courseTitle varchar(100), department varchar(100), PRIMARY"
			 		+ " KEY (courseID))");
			 prepstate.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Connect.Close(connection, prepstate);
	}
	
	public static void insert(Courses course) throws SQLException
	{
		Connection connection = null;
		PreparedStatement prepstate = null;
	try 
	{
		connection = Connect.getConnection();
		prepstate = connection.prepareStatement("INSERT INTO Courses (courseID, courseTitle, department) VALUES (?, ?, ?)");
		prepstate.setString(1,  course.getCourseID());
		prepstate.setString(2, course.getCourseTitle());
		prepstate.setString(3, course.getDepartment());
		
		prepstate.executeUpdate();
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	Connect.Close(connection, prepstate);
	}
}



