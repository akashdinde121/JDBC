package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigConnect {


	static Connection connectdatabase() throws ClassNotFoundException, SQLException
	{

		System.out.println("Connecting To Database.........");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Serching A Driver Class.......");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbk","root","root");
		System.out.println("Connected Succesfully.........");
		System.out.println();
		return con; 
	}
}
