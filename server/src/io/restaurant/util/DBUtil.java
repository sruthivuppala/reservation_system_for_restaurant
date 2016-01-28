package io.restaurant.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/"
			+ "fonduefun_reservation_system";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL JDBC Driver loaded");
		}
		catch(ClassNotFoundException e){
			System.err.println("Error loading JDBC Driver");
			e.printStackTrace();
		}
	}
	
	public static Connection connect(){
		Connection con = null;
		
		try{
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		}
		catch(SQLException e){
			System.err.println("Error connecting to the database");
			e.printStackTrace();
		}
		return con;
	}
}
