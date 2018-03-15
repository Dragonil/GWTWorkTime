package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.shared.Notiz;

public class NotizMapper {

	public static void Notizanlegen(Notiz notiz) {

		Connection con = DBConnection.connection();
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO notiz (id, inhalt, datum, farbe) VALUES (" + 
					notiz.getId() + notiz.getInhalt() +
					notiz.getfarbe() + notiz.getDatum() +")");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


public static void Notizloeschen(Notiz notiz) {
	loeschen(notiz.getId());
}

	public static void loeschen(int id) {

		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM notiz " + "WHERE id = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

}
	public static Notiz findById(int id) {
		Connection con = DBConnection.connection();

		Notiz notiz = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM notiz " + "WHERE id = " + id);
			if (rs.next()) {
				Notiz n = new Notiz(rs.getString("inhalt"),
						rs.getString("farbe"));
				n.setId(rs.getInt("id"));
				n.setDatum(rs.getDate("datum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notiz;
	}
	public static Vector<Notiz> findAll() {
		
		Connection con = DBConnection.connection();
		Vector<Notiz> result = new Vector<Notiz>();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from notiz " +
							"where notiz.id");
			
			
			while (rs.next()) {
			
			Notiz n = new Notiz(rs.getString("inhalt"), 
					rs.getString("farbe"));
					n.setId(rs.getInt("id"));
			
			result.addElement(n);
			}
			
			} catch (SQLException e2) {
			e2.printStackTrace();
		} 
		return result;
		
	}

}
