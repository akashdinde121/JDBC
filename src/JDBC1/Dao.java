package JDBC1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import JDBCConnect.ConficConnect;

public class Dao {



	public static void CreateTable() throws ClassNotFoundException, SQLException
	{
		Connection con =ConfigConnect.connectdatabase(); 
		Statement st= con.createStatement();
		st.execute("create table student(id int ,name varchar(20),age int ,gender varchar(20))");
		System.out.println("Create Table.....");
	}


	public static void InsertData() throws ClassNotFoundException, SQLException
	{
		Scanner sc= new Scanner(System.in);
		Connection con = ConfigConnect.connectdatabase();
		PreparedStatement ps= con.prepareStatement("insert into student (id, name ,age,gender)values(?,?,?,?)");

		//for(int i=1; i<=3; i++) {
			System.out.println("Enter Student Id ");
			int id=sc.nextInt();

			System.out.println("Enter Student name");
			String name=sc.next();

			System.out.println("Enter Student Age");
			int age=sc.nextInt();

			System.out.println("Enter Gender");
			String gender=sc.next();

			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setInt(3, age);
			ps.setString(4, gender);
			ps.execute();

		//}
		System.out.println("Data Inserted.....");
	}

	public static void UpdateAge() throws ClassNotFoundException, SQLException
	{
		Scanner sc= new Scanner(System.in);
		Connection con = ConfigConnect.connectdatabase();
		PreparedStatement ps= con.prepareStatement("update student set age=? where id=?");

		System.out.println("Enter New Age");
		int age=sc.nextInt();

		System.out.println("Enter Where Id");
		int id=sc.nextInt();

		ps.setInt(1, age);
		ps.setInt(2, id);
		ps.execute();

		System.out.println("Update Age....");
	}

	public static void UpdateName() throws ClassNotFoundException, SQLException
	{
		Scanner sc= new Scanner(System.in);
		Connection con = ConfigConnect.connectdatabase();
		PreparedStatement ps= con.prepareStatement("update student set name=? where id=?");

		System.out.println("Enter New Name");
		String name=sc.next();

		System.out.println("Enter Where Id");
		int id=sc.nextInt();

		ps.setString(1, name);
		ps.setInt(2, id);
		ps.execute();

		System.out.println("Update Name....");
	}


	public static void UpdateGender() throws ClassNotFoundException, SQLException
	{
		Scanner sc= new Scanner(System.in);
		Connection con = ConfigConnect.connectdatabase();
		PreparedStatement ps= con.prepareStatement("update student set gender=? where id=?");

		
		System.out.println("Enter New Gender");
		String gender=sc.next();

		System.out.println("Enter Where Id");
		int id=sc.nextInt();

		ps.setString(1, gender);
		ps.setInt(2, id);
		ps.execute();

		System.out.println("Update Gender....");
	}

	public static void DeleteData() throws ClassNotFoundException, SQLException
	{
		Scanner sc= new Scanner(System.in);
		Connection con= ConfigConnect.connectdatabase();
		PreparedStatement ps= con.prepareStatement("delete from student where id=?");

		System.out.println("Enter Id");
		int id=sc.nextInt();

		ps.setInt(1,id);
		ps.execute();

		System.out.println("Delete Data....");
	}

	public static void GetAllData() throws ClassNotFoundException, SQLException
	{
		Connection con = ConfigConnect.connectdatabase();

		PreparedStatement ps= con.prepareStatement("select * from student");
		ResultSet rs= ps.executeQuery();
		System.out.println("Getting A Data in Database.....");
		System.out.println();


		ArrayList<Student> list = new ArrayList<>();

		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getString(4));
			System.out.println();
		}
		System.out.println("Data Printed...");
	}
}
