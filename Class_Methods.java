


package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Class_Methods {
	public static void createTable() throws SQLException
	{
		Connection connection = null;
		PreparedStatement prepstate = null;
		//WHAT IS VARCHAR????
		try {
			connection = Connect.getConnection();
			prepstate = connection.prepareStatement("CREATE TABLE IF NOT EXISTS"
					+ " Classes (courseID varchar(30) NOT NULL,"
					+ " empID int NOT NULL, sectionNO int NOT NULL,"
					+ " year varchar(4), semester varchar(10), grade varchar(1),"
					+ " PRIMARY KEY (courseID, empID, sectionNO))");
			prepstate.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		Connect.Close(connection, prepstate);
	}
	
	public static void insert(Classes classes) throws SQLException
	{
		Connection connection = null;
		PreparedStatement prepstate = null;
		
		try {
			connection = Connect.getConnection();
			prepstate = connection.prepareStatement("INSERT INTO Classes (courseID,"
					+ " empID, sectionNO, year, semester, grade) VALUES (?, ?, ?, ?, ?, ?)");
			prepstate.setString(1, classes.getCourseID());
			prepstate.setInt(2, classes.getEmpID());
			prepstate.setInt(3, classes.getSectionNO());
			prepstate.setInt(4, classes.getYear());
			prepstate.setString(5, classes.getSemester());
			prepstate.setString(6, classes.getGrade());
			prepstate.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		Connect.Close(connection, prepstate);
	}
	
	public static void update(Classes classes, Students stud, String grade) throws SQLException
	{
		Connection connection = null;
		PreparedStatement prepstate = null;
		
		try {
			connection = Connect.getConnection();
			prepstate = connection.prepareStatement("UPDATE Classes SET"
					+ " grade = ? WHERE"
					+ " empID = ? AND courseID = ?");
			prepstate.setString(1, grade);
			prepstate.setInt(2, stud.getEmpID());
			prepstate.setString(3, classes.getCourseID());
			
			prepstate.executeUpdate();
				
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Connect.Close(connection, prepstate);
	}
}

