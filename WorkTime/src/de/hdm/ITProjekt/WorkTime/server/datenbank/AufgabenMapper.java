package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;
import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;

public class AufgabenMapper {

	public static void insert (Aufgabe a)
	{
		Connection con = DBConnection.connection();
		
		java.util.Date date = Calendar.getInstance().getTime();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		
		
		try {
			PreparedStatement stmt = con.prepareStatement("INSERT into Aufgabe (beschreibung, titel, startDatum, endDatum, status, arbeitszeit, prio, userID) VALUES(?,?,?,?,?,?,?,?)");
			stmt.setString(1, a.getBeschreibung());
			stmt.setString(2, a.getTitel());
			stmt.setDate(3, sqlDate);
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
	public static Aufgabe findbyID (String titel)
	{
		Connection con = DBConnection.connection();
		Aufgabe aufgabe = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Aufgabe WHERE titel = " + titel);
			while(rs.next()) {
				aufgabe = new Aufgabe(rs.getString("startDatum"), rs.getString("endDatum"), rs.getString("titel"), rs.getString("beschreibung"), rs.getInt("arbeitszeit"), rs.getInt("status"), rs.getInt("prio"), rs.getInt("userID"));
				}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return aufgabe;

	}
	public static Vector<Aufgabe> findAll ()
	{
		Connection con = DBConnection.connection();
		Vector<Aufgabe> output = new Vector<Aufgabe>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Aufgabe ");
			while(rs.next()) {
			output.add(new Aufgabe(rs.getString("startDatum"), rs.getString("endDatum"), rs.getString("titel"), rs.getString("beschreibung"), rs.getInt("arbeitszeit"), rs.getInt("status"), rs.getInt("prio"), rs.getInt("userID")));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;

	}
	public static void delete (Aufgabe a)
	{
		Connection con = DBConnection.connection();
		
		try {
			PreparedStatement stmt = con.prepareStatement("DELETE from Aufgabe (beschreibung, titel, startDatum, endDatum, status, arbeitszeit, prio, userID) VALUES(?,?,?,?,?,?,?,?)");
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


public static void update (Aufgabe a)
{
	Connection con = DBConnection.connection();
	
	try {
		PreparedStatement stmt = con.prepareStatement("UPDATE Aufgabe (beschreibung, titel,  endDatum, status, arbeitszeit, prio, userID) VALUES(?,?,?,?,?,?,?)");
		stmt.setString(1, a.getBeschreibung());
		stmt.setString(2, a.getTitel());
		stmt.setString(3, a.getEndDatum());
		stmt.setInt(4, a.getStatus());
		stmt.setInt(5, a.getArbeitszeit());
		stmt.setInt(6, a.getPrio());
		stmt.setInt(7, a.getUserID());
		stmt.executeUpdate();
	}
	catch (SQLException e) {
		e.printStackTrace();
		}
	}
}


