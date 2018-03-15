package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				u.setLetzterLogin(rs.getDate("letzterLogin"));

				result.addElement(u);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static User finByEmail(String email) {
		Connection con = DBConnection.connection();
		User u = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM User WHERE email =" + email);

			if (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setName(rs.getString("name"));
				u.setPasswort(rs.getString("passwort"));
				u.setTyp(rs.getInt("typ"));
				u.setVorname(rs.getString("vorname"));
				u.setLetzterLogin(rs.getDate("letzterLogin"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;

	}

	public static User findById(int id) {
		Connection con = DBConnection.connection();
		User u = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM User WHERE id = " + id);
			if (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setName(rs.getString("name"));
				u.setPasswort(rs.getString("passwort"));
				u.setTyp(rs.getInt("typ"));
				u.setVorname(rs.getString("vorname"));
				u.setLetzterLogin(rs.getDate("letzterLogin"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;

	}

	public static void insert(User user) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO User(id, email, name, passwort, typ, vorname, letzterLogin) VALUES ("
					+ user.getId() + user.getEmail() + user.getName() + user.getPasswort() + user.getTyp()
					+ user.getVorname() + user.getLetzterLogin() + ")");

			/**
			 * PreparedStatement statement = con .prepareStatement("INSERT INTO blogeintrag
			 * (id, titel, untertitel) VALUES (?, ?, ?)"); statement.setInt(1,
			 * blogeintrag.getId()); statement.setString(2, blogeintrag.getTitel());
			 * statement.setString(3, blogeintrag.getUntertitel());
			 * statement.executeUpdate();
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void delete(User user) {
		delete(user.getId());
	}

	public static void delete(int id) {
		Connection con = DBConnection.connection();
		try {

			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM User WHERE id = " + id);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	public static void update(User user) {
		Connection con = DBConnection.connection();
		try {
			PreparedStatement stmt = con.prepareStatement("UPDATE user (name, email, passwort, typ, vorname) VALUES (?,?,?,?,?)");
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPasswort());
			stmt.setInt(4, user.getTyp());
			stmt.setString(5, user.getVorname());
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
