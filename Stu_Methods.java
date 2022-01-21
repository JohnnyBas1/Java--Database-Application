
package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Stu_Methods {
	
	
	public static void createTable() throws SQLException
	{
		Connection connection = null;
		PreparedStatement prepstatement = null;
	
	try {
		connection = Connect.getConnection();
		prepstatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS "
				+ "Students(empID bigint NOT NULL,"
				+ "firstName varchar(52), lastName varchar(52), email varchar(100),"
				+ "gender varchar(100), PRIMARY KEY (empID))");
		prepstatement.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	Connect.Close(connection, prepstatement);
}
	public static void insert(Students student) throws SQLException
	{
		Connection connection = null;
		PreparedStatement prepstatement = null;
		
		try {
			connection = Connect.getConnection();
			prepstatement = connection.prepareStatement("INSERT INTO Students (empID, "
					+ "firstName, lastName, email, gender) VALUES(?,?,?,?,?)");
			prepstatement.setInt(1, student.getEmpID());
			prepstatement.setString(2, student.getFirstName());
			prepstatement.setString(3, student.getLastName());
			prepstatement.setString(4, student.getEmail());
			prepstatement.setString(5, student.getGender());
			prepstatement.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Connect.Close(connection, prepstatement);
	}
	
	public static void delete(int emplid) throws SQLException
	{
		Connection connection = null;
		PreparedStatement prepstate = null;
		try {
			connection = Connect.getConnection();
			prepstate = connection.prepareStatement("DELETE FROM Students WHERE empID = ?");
			prepstate.setInt(1, emplid);
			prepstate.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Connect.Close(connection, prepstate);
	}
		
}


