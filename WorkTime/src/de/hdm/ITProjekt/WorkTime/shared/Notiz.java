package de.hdm.ITProjekt.WorkTime.shared;

import java.sql.Date;

public class Notiz extends BusinessObject{
	
	private int id;
	private String inhalt;
	private Date datum;
	private String farbe;
	
	
	
	
	public Notiz(int id) {
		super();
		this.id = id;
	}

		

	public Notiz(String inhalt, Date datum) {
		super();
		this.inhalt = inhalt;
		this.datum = datum;
	}


	public Notiz(int id, String inhalt, Date datum, String farbe) {
		super();
		this.id = id;
		this.inhalt = inhalt;
		this.datum = datum;
		this.farbe = farbe;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInhalt() {
		return inhalt;
	}
	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getFarbe() {
		return farbe;
	}
	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}
	
	
	

}
