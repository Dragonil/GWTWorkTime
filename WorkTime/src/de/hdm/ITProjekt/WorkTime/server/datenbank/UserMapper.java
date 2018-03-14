package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.shared.User;

public class UserMapper {

	public static Vector<User> findAll() {
		Connection con = DBConnection.connection();
		Vector<User> result = new Vector<User>();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM User ORDER BY name asc");

			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setName(rs.getString("name"));
				u.setPasswort(rs.getString("passwort"));
				u.setTyp(rs.getInt("typ"));
				u.setVorname(rs.getString("vorname"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
