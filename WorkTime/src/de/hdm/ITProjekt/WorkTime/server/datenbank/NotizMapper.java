package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.shared.bo.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.bo.Notiz;


public class NotizMapper {
	
	private static NotizMapper notizMapper = null;
	
	protected NotizMapper() {
		
	}
	
	/* Singleton NotizMapper */
	
	public static NotizMapper notizMapper(){
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
	          .executeQuery("SELECT id, inhalt, datum, farbe FROM notiz "
	              + "WHERE id=" + id);

	      if (rs.next()) {
	        Notiz n = new Notiz();
	        n.setId(rs.getInt("id"));
	        n.setInhalt(rs.getString("inhalt"));
	        n.setDatum(rs.getDate("datum"));
	        n.setFarbe(rs.getString("farbe"));
	      
	        return n;
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
		        Notiz n = new Notiz();
		        n.setId(rs.getInt("id"));
		        n.setDatum(rs.getDate("datum"));
		        n.setFarbe(rs.getString("farbe"));
		        n.setInhalt(rs.getString("inhalt"));

		        result.addElement(n);
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

	 
	  public static void delete(Notiz note) {
			delete(note.getId());
		}

		public static void delete(int id) {
			Connection con = DBConnection.connection();
			try {
				Statement stmt = con.createStatement();
				stmt.executeUpdate("DELETE FROM notiz " + "WHERE id = " + id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		public static void removeTable() {

			Connection con = DBConnection.connection();
			Statement stmt;
			try {
				stmt = con.createStatement();
				stmt.executeUpdate("DROP TABLE notiz");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		/* TODO Generate Table */
		
		public static void createTable() {
			String sqlString = "CREATE TABLE notiz (\n" + 
					"  id int NOT NULL,\n" + 
					"  inhalt varchar(45) DEFAULT NULL,\n" + 
					"  farbe varchar(45) DEFAULT NULL,\n" + 
					"  datum date DEFAULT NULL,\n" + 
					"  PRIMARY KEY (id)\n" + 
					"  FOREIGN KEY (id) REFERENCES aufgabe(id)" +
					"  )";
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

	 



