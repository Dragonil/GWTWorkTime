package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import de.hdm.ITProjekt.WorkTime.shared.aufgaben;

public class AufgabenMapper {

	public static void insert (aufgaben a)
	{
		Connection con = DBConnection.connection();
		
		try {
			PreparedStatement stmt = con.prepareStatement("INSERT into Aufgabe (beschreibung, titel, startDatum, endDatum, status, arbeitszeit, prio, userID) VALUES(?,?,?,?,?,?,?,?)");
			stmt.setString(1, a.getBeschreibung());
			stmt.setString(2, a.getTitel());
			stmt.setString(3, a.getStartDatum());
			stmt.setString(4, a.getEndDatum());
			stmt.setInt(5, a.getStatus());
			stmt.setInt(6, a.getArbeitszeit());
			stmt.setInt(7, a.getPrio());
			stmt.setInt(8, a.getUserID());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static aufgaben findbyID (String titel)
	{
		Connection con = DBConnection.connection();
		aufgaben aufgabe = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Aufgabe WHERE titel = " + titel);
				aufgabe = new aufgaben(rs.getString("startDatum"), rs.getString("endDatum"), rs.getString("titel"), rs.getString("beschreibung"), rs.getInt("arbeitszeit"), rs.getInt("status"), rs.getInt("prio"), rs.getInt("userID");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return aufgabe;

	}
	public static Vector<aufgaben> findbyALL (aufgaben a)
	{
		Connection con = DBConnection.connection();
		try {
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
