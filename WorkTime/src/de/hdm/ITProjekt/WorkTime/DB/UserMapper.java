package de.hdm.ITProjekt.WorkTime.DB;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.shared.bo.User;
import de.hdm.ITProjekt.WorkTime.shared.bo.BusinessObject;

public class UserMapper {

	private static UserMapper userMapper = null;

	
	protected UserMapper() {
	}
	
	public static UserMapper customerMapper() {
		if (userMapper == null) {
			userMapper = new UserMapper();
		}

		return userMapper;
	}
	
	public User findByKey(int id) {
		// DB-Verbindung holen
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausfüllen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery(
					"SELECT id, name, vorname FROM user " + "WHERE id=" + id + " ORDER BY name");

			if (rs.next()) {
				// Ergebnis-Tupel in Objekt umwandeln
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setFirstName(rs.getString("vorname"));
				u.setLastName(rs.getString("name"));

				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}
	
	public Vector<User> findAll() {
		// Ergebnisvektor vorbereiten
		Vector<User> result = new Vector<User>();

		Connection con = DBConnection.connection();
		try {
			
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT id, vorname, name " + "FROM user " + "ORDER BY name");

			// Für jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt
			// erstellt.
			while (rs.next()) {
				User c = new User();
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("vorname"));
				c.setLastName(rs.getString("name"));

				// Hinzufügen des neuen Objekts zum Ergebnisvektor
				result.addElement(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Ergebnisvektor zurückgeben
		return result;
	}
	
	public Vector<User> findByLastName(String name) {
		Connection con = DBConnection.connection();
		Vector<User> result = new Vector<User>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id, vorname, name " + "FROM user "
					+ "WHERE name LIKE '" + name + "' ORDER BY name");

			// Für jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt
			// erstellt.
			while (rs.next()) {
				User c = new User();
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("vorname"));
				c.setLastName(rs.getString("name"));

				// Hinzufügen des neuen Objekts zum Ergebnisvektor
				result.addElement(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Ergebnisvektor zurückgeben
		return result;
	}
	
	public User insert(User u) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM user ");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * u erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				u.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO user (id, name, nachname) " + "VALUES (" + u.getId() + ",'"
						+ u.getFirstName() + "','" + u.getLastName() + "')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
			return u;
	}
	
	public User update(User u) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE user " + "SET vorname=\"" + u.getFirstName() + "\", " + "nachname=\""
					+ u.getLastName() + "\" " + "WHERE id=" + u.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Um Analogie zu insert(Customer c) zu wahren, geben wir c zurück
		return u;
	}
	
	public void delete(User u) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM user " + "WHERE id=" + u.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


