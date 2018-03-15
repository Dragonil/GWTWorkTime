package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con = null;

	private static String datenbankTyp = "mySQL";
	
	private static String datenbankUrl = "jdbc:mysql://vweb12.nitrado.net:3306?user=ni249339_1sql9&password=ITProjekt";
	
	public static Connection connection() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(datenbankUrl);
		} catch (SQLException e1) {
			con = null;
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}
