package de.hdm.ITProjekt.WorkTime.shared;

import java.util.Date;

public class Notiz {

	private int id;
	private String Inhalt;
	private String farbe;
	private Date datum;
	
	public Notiz(String Inhalt, String farbe) {
		this.Inhalt = Inhalt;
		this.farbe = farbe;
		
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInhalt() {
		return Inhalt;
	}

	public void setInhalt(String inhalt) {
		Inhalt = inhalt;
	}

	public String getfarbe() {
		return farbe;
	}

	public void setfarbe(String farbe) {
		this.farbe = farbe;
	}
	
	
	
	
}
