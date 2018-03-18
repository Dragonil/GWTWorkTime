package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.shared.AufgabenAdministration;
import de.hdm.ITProjekt.WorkTime.DB.AufgabeMapper;
import de.hdm.ITProjekt.WorkTime.DB.DBConnection;

import de.hdm.ITProjekt.WorkTime.shared.bo.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.bo.User;

public class AufgabeMapper {
	
		
	private static AufgabeMapper aufgabeMapper = null;
	
	public AufgabeMapper() {
		
	}
	
	/*
	 * Singleton AufgabenMapper
	 */
	
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
			Statement stmt = (Statement) con.createStatement();

			// Statement ausfüllen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery(
					"SELECT id, titel, startDatum, endDatum, status, arbeitszeit, prio"
					+ " FROM user " + "WHERE id=" + id);

			if (rs.next()) {
				// Ergebnis-Tupel in Objekt umwandeln
				
				Aufgabe a = new Aufgabe();
				a.setId(rs.getInt("id"));
				a.setTitel(rs.getString("titel"));
				a.setStartDatum(rs.getDate("startDatum"));
				a.setEndDatum(rs.getDate("endDatum"));
				a.setStatus(rs.getInt("status"));
				a.setArbeitszeit(rs.getInt("arbeitszeit"));
				a.setPrio(rs.getInt("prio"));

				return a;
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
			Statement stmt = (Statement) con.createStatement();

			ResultSet rs = stmt.executeQuery(
					"SELECT id, titel, startDatum, endDatum, status, arbeitszeit, prio"
					+ " FROM user " + "ORDER BY startDatum");

			// Für jeden Eintrag im Suchergebnis wird nun ein Customer-Objekt
			// erstellt.
			while (rs.next()) {
				Aufgabe a = new Aufgabe();
				a.setId(rs.getInt("id"));
				a.setTitel(rs.getString("titel"));
				a.setStartDatum(rs.getDate("startDatum"));
				a.setEndDatum(rs.getDate("endDatum"));
				a.setStatus(rs.getInt("status"));
				a.setArbeitszeit(rs.getInt("arbeitszeit"));
				a.setPrio(rs.getInt("prio"));

				// Hinzufügen des neuen Objekts zum Ergebnisvektor
				result.addElement(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Ergebnisvektor zurückgeben
		return result;
	}
	
	public Aufgabe findByTitel(String titel) {
		// DB-Verbindung holen
				Connection con = DBConnection.connection();

				try {
					// Leeres SQL-Statement (JDBC) anlegen
					Statement stmt = (Statement) con.createStatement();

					// Statement ausfüllen und als Query an die DB schicken
					ResultSet rs = stmt.executeQuery(
							"SELECT id, titel, startDatum, endDatum, status, arbeitszeit, prio"
							+ " FROM user " + "WHERE titel=" + titel);

					if (rs.next()) {
						// Ergebnis-Tupel in Objekt umwandeln
						
						Aufgabe a = new Aufgabe();
						a.setId(rs.getInt("id"));
						a.setTitel(rs.getString("titel"));
						a.setStartDatum(rs.getDate("startDatum"));
						a.setEndDatum(rs.getDate("endDatum"));
						a.setStatus(rs.getInt("status"));
						a.setArbeitszeit(rs.getInt("arbeitszeit"));
						a.setPrio(rs.getInt("prio"));

						return a;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}

				return null;
			}
	
	public Aufgabe insert(Aufgabe a) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM aufgabe ");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * u erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				a.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO aufgabe (id, titel, startDatum, endDatum) " + "VALUES (" + a.getId() + ",'"
						+ a.getTitel() + "','" + a.getStartDatum() + "','" + a.getEndDatum()+ "')");
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
			stmt.executeUpdate("UPDATE aufgabe " + "SET titel=\"" + a.getTitel() + "\", " + "startDatum=\""
					+ a.getStartDatum() + "\" " + "WHERE id=" + a.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	return u;
	}
	
	public static void delete(Aufgabe aufgabe) {
		delete(aufgabe.getId());
	}

	public static void delete(int id) {
		NotizMapper.delete(id);
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM aufgabe " + "WHERE id = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public static void removeTable() {
		NotizMapper.removeTable();
		Connection con = DBConnection.connection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate("DROP TABLE aufgabe");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/* TODO Generate Table */

	public static void createTable() {
		String sqlString = "CREATE TABLE aufgabe (\n" + 
				"  id int NOT NULL,\n" + 
				"  titel varchar(45) DEFAULT NULL,\n" + 
				"  untertitel varchar(45) DEFAULT NULL,\n" + 
				"  PRIMARY KEY (id)\n" + 
				" )";
		Connection con = DBConnection.connection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sqlString);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}


