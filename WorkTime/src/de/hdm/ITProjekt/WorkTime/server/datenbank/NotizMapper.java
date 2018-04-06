package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.shared.Notiz;

public class NotizMapper {
	

	public static void Notizanlegen(Notiz notiz) {
		java.util.Date date = Calendar.getInstance().getTime();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		Connection con = DBConnection.connection();
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO Notiz ( inhalt, datum, farbe, aufgabeID) VALUES ('"+ notiz.getInhalt() +"','"+ sqlDate + "','"+
					notiz.getfarbe() +"', 1)");
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
			stmt.executeUpdate("DELETE FROM Notiz " + "WHERE id = " + id);
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM Notiz " + "WHERE id = " + id);
			if (rs.next()) {
				Notiz n = new Notiz(rs.getString("inhalt"),//mit get hol ich daten aus klasse und schrieb in db
						rs.getString("farbe"));
				n.setId(rs.getInt("id"));
				n.setDatum(rs.getDate("datum"));//mit set hol ich Daten aus db und schreib sie in die Klassen
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notiz;
	}
	
	
	public static Vector<Notiz> findAll() {
		
		Connection con = DBConnection.connection();
		Vector<Notiz> result = new Vector<Notiz>();//Vector, weil alle Daten zur�ck will die werden im Vector abgespeichert
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from Notiz ");
			
			
			while (rs.next()) {
			
			Notiz n = new Notiz(rs.getString("inhalt"), 
					rs.getString("farbe"));
					n.setId(rs.getInt("id"));
					n.setDatum(rs.getDate("datum"));
			
			result.addElement(n);//Notiz wird in Vector geschrieben
			}
			
			} catch (SQLException e2) {
			e2.printStackTrace();
		} 
		return result;
		
	}

}
