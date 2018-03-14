package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import de.hdm.ITProjekt.WorkTime.shared.User;

public class UserMapper {
	
	public static void findAll() {
		DBConnection con = Connection.connection();
		Vector <User> result = new Vector <User>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM User ORDER BY name asc");
			
			while (rs.next()) {
				u.setId(rs.getInt(id));
			}
		}
		
	}

}
