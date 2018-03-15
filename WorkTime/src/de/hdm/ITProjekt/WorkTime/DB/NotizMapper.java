package de.hdm.ITProjekt.WorkTime.DB;


import java.sql.*;
import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.Notiz;


public class NotizMapper {
	
	private static NotizMapper notizMapper = null;
	
	protected NotizMapper() {
		
	}
	
	// Singleton 
	public static NotizMapper customerMapper() {
		    if (notizMapper == null) {
		    	notizMapper = new NotizMapper();
		    }

		    return notizMapper;
		  }
	 
	
	  public Notiz findByKey(int id) {

	    Connection con = DBConnection.connection();

	    try {
	     
	      Statement stmt = con.createStatement();
	      ResultSet rs = stmt
	          .executeQuery("SELECT id, datum, inhalt, farbe FROM notiz "
	              + "WHERE id=" + id);

	      if (rs.next()) {
	        Notiz c = new Notiz();
	        c.setId(rs.getInt("id"));
	        c.setDatum(rs.getDate("datum"));
	        c.setFarbe(rs.getString("farbe"));
	        c.setInhalt(rs.getString("inhalt"));

	        return c;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }
	    
	    return null;

	  }
 
	  
	  public Vector<Notiz> findAll() {
	    Connection con = DBConnection.connection();
	    Vector<Notiz> result = new Vector<Notiz>();

	    try {
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT id, inhalt, datum, farbe "
	          + "FROM notiz " + "ORDER BY datum");

	      while (rs.next()) {
	        Notiz c = new Notiz();
	        c.setId(rs.getInt("id"));
	        c.setInhalt(rs.getString("inhalt"));
	        c.setDatum(rs.getDate("datum"));
	        c.setFarbe(rs.getString("farbe"));
	        
	        result.addElement(c);
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return result;
	  }

	
	  public Vector<Notiz> findByDate(Date datum) {
		  Connection con = DBConnection.connection();
		  Vector <Notiz> result = new Vector<Notiz>();
		  

		    try {
		     
		      Statement stmt = con.createStatement();
		      ResultSet rs = stmt
		          .executeQuery("SELECT id, datum, inhalt, farbe FROM notiz "
		              + "WHERE datum=" + datum + "ORDER BY aufgabeID");

		      if (rs.next()) {
		        Notiz c = new Notiz();
		        c.setId(rs.getInt("id"));
		        c.setDatum(rs.getDate("datum"));
		        c.setFarbe(rs.getString("farbe"));
		        c.setInhalt(rs.getString("inhalt"));

		        result.addElement(c);
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		    }

		    return result;
		  }

	  
	  
	  public Vector<Notiz> findByTask(Aufgabe a) {
		  Connection con = DBConnection.connection();
		  Vector <Notiz> result = new Vector<Notiz>();

		    try {
		     
		      Statement stmt = con.createStatement();
		      ResultSet rs = stmt
		          .executeQuery("SELECT id, datum, inhalt, farbe FROM notiz "
		              + "WHERE aufgabeID=" + a.getId() + "ORDER BY datum");

		      if (rs.next()) {
		        Notiz c = new Notiz();
		        c.setId(rs.getInt("id"));
		        c.setDatum(rs.getDate("datum"));
		        c.setFarbe(rs.getString("farbe"));
		        c.setInhalt(rs.getString("inhalt"));
		        
		        result.addElement(c);
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		    }

		    return result;
		  }


	 
	  public Notiz insert(Notiz c) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM notiz ");

	      if (rs.next()) {
	        c.setId(rs.getInt("maxid") + 1);
	        stmt = con.createStatement();
	        stmt.executeUpdate("INSERT INTO notiz (id, inhalt, datum, farbe) "
	            + "VALUES (" + c.getId() + ",'" + c.getInhalt() + "','"
	            + c.getDatum() + ",'" + c.getFarbe() + "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return c;
	  }

	 
	  public Notiz update(Notiz c) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE notiz " + "SET inhalt=\""
	          + c.getInhalt() + "\", " + "farbe=\"" + c.getFarbe() 
	          + "\", " + "datum=\"" + c.getDatum() +"\""
	          + "WHERE id=" + c.getId());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return c;
	  }

	 
	  public void delete(Notiz c) {
	    Connection con = DBConnection.connection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM notiz " + "WHERE id=" + c.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	
	 
}

	 


