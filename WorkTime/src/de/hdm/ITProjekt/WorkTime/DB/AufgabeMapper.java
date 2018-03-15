package de.hdm.ITProjekt.WorkTime.DB;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.shared.bo.User;
import de.hdm.ITProjekt.WorkTime.shared.bo.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.bo.BusinessObject;


public class AufgabeMapper {

	private static UserMapper aufgabeMapper = null;

	
	protected AufgabeMapper() {
	}
	
	public static AufgabeMapper aufgabeMapper() {
		if (aufgabeMapper == null) {
			aufgabeMapper = new AufgabeMapper();
		}
		return aufgabeMapper;
	}
	
	public Aufgabe findByKey(int id) {
		// DB-Verbindung holen
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery(
					"SELECT id, titel, startDatum, endDatum FROM user " + "WHERE id=" + id);

			if (rs.next()) {
				// Ergebnis-Tupel in Objekt umwandeln
				Aufgabe u = new Aufgabe();
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
	
	public Vector<Aufgabe> findAll() {
		// Ergebnisvektor vorbereiten
		Vector<Aufgabe> result = new Vector<Aufgabe>();

		Connection con = DBConnection.connection();
		try {
			
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT id, titel, startDatum, endDatum " + "FROM user " + "ORDER BY name");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt
			// erstellt.
			while (rs.next()) {
				User c = new User();
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("vorname"));
				c.setLastName(rs.getString("name"));

				// Hinzuf�gen des neuen Objekts zum Ergebnisvektor
				result.addElement(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Ergebnisvektor zur�ckgeben
		return result;
	}
	
	public Vector<User> findByTitel(String titel) {
		Connection con = DBConnection.connection();
		Vector<User> result = new Vector<User>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id, titel, startDatum, endDatum" + "FROM aufgabe "
					+ "WHERE titel LIKE '" + titel + "'");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt
			// erstellt.
			while (rs.next()) {
				Aufgabe a = new User();
				a.setId(rs.getInt("id"));
				a.setFirstName(rs.getString("vorname"));
				a.setLastName(rs.getString("name"));

				// Hinzuf�gen des neuen Objekts zum Ergebnisvektor
				result.addElement(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Ergebnisvektor zur�ckgeben
		return result;
	}
	
	public Aufgabe insert(Aufgabe a) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM aufgabe ");

			// Wenn wir etwas zur�ckerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * u erh�lt den bisher maximalen, nun um 1 inkrementierten
				 * Prim�rschl�ssel.
				 */
				a.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tats�chliche Einf�geoperation
				stmt.executeUpdate("INSERT INTO aufgabe (id, titel, startDatum, endDatum) " + "VALUES (" + u.getId() + ",'"
						+ a.getFirstName() + "','" + a.getLastName() + "')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
			return a;
	}
	
	public Aufgabe update(Aufgabe a) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE aufgabe " + "SET titel=\"" + a.getFirstName() + "\", " + "startDatum=\""
					+ a.getLastName() + "\" " + "WHERE id=" + a.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Um Analogie zu insert(Customer c) zu wahren, geben wir c zur�ck
		return u;
	}
	
	public void delete(Aufgabe a) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM aufgabe " + "WHERE id=" + a.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


