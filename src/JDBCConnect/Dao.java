package JDBCConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Dao {

	public static void createdatabase() throws ClassNotFoundException, SQLException
	{
		Connection con= ConficConnect.connectdatabase();
		Statement st= con.createStatement();
		st.execute("create database jbk");
		System.out.println("Create Database......");
	}

	public static void createtable() throws ClassNotFoundException, SQLException
	{
		Connection con= ConficConnect.connectdatabase();
		Statement st= con.createStatement();
		st.execute("create table team(id int , name varchar(20),age int )");
		System.out.println("Create Table..........");
	}

	public static void insertdata() throws ClassNotFoundException, SQLException
	{
		Scanner sc= new Scanner(System.in);

		Connection con= ConficConnect.connectdatabase();
		PreparedStatement ps = con.prepareStatement("insert into team (id, name ,age)values(?,?,?)");
		for(int i=1; i<=5; i++)
		{
		System.out.println("Enter Id");
		int id=sc.nextInt();
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter Age");
		int age=sc.nextInt();
		
		ps.setInt(1,id);
		ps.setString(2 ,name);
		ps.setInt(3, age);
		ps.execute();
		
         
		}
	
		System.out.println("Data Inserted........");
	}

	public static void deletedata() throws SQLException, ClassNotFoundException
	{

		Scanner sc= new Scanner(System.in);
		
		Connection con= ConficConnect.connectdatabase();
		PreparedStatement ps = con.prepareStatement("delete from team where id=?");
		System.out.println("Enter Id");
		int id=sc.nextInt();
		ps.setInt(1, id);
		ps.execute();
		System.out.println("Delete A Data........");
	}

	public static void AgeUpdate() throws ClassNotFoundException, SQLException
	{
		Scanner sc= new Scanner(System.in);
		Connection con = ConficConnect.connectdatabase();
		PreparedStatement ps = con.prepareStatement("update team set age=? where id=?");

		System.out.println("Enter New Age");
		int age=sc.nextInt();
	
		System.out.println("Enter Your Id ");
		int id=sc.nextInt();
		
		ps.setInt(1, age);
		ps.setInt(2, id);
		
		ps.execute();
		System.out.println("Data update........");
	}

	public static void GetAllSData() throws SQLException, ClassNotFoundException
	{
		
		Connection con = ConficConnect.connectdatabase();
		PreparedStatement ps= con.prepareStatement("select * from team");
		ResultSet rs= ps.executeQuery();
		System.out.println("Getting A Data in Database.....");

		ArrayList<team> list = new ArrayList<>();
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println();
		}
		System.out.println("Display Data Succesfully.......");

	}
	public static void GetHighestAge() throws ClassNotFoundException, SQLException
	{
		Connection con = ConficConnect.connectdatabase();
		PreparedStatement ps= con.prepareStatement("select * from team where age>20");
		ResultSet rs=ps.executeQuery();
		ArrayList<team> list = new ArrayList<>();
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println();
		}


	}
}
