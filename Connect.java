

package application;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {
	
	
	
	public static Connection getConnection()
	{
		
		Connection connection = null;
	
	try {
		//Load MySQL driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_application", "root","G0Ljrny3;-;");
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("Failed to connect. CEREAL");
	}
		return connection;
	}
	public static void Close(Connection connection, PreparedStatement prepstate) throws SQLException
	{
		if(connection != null)
		{
			connection.close();
		}
		if(prepstate != null)
		{
			prepstate.close();
		}
	}

}
