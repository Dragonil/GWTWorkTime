package de.hdm.ITProjekt.WorkTime.shared;

import java.io.Serializable;
import java.util.*;


public class Aufgabe implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String startDatum;
	private String endDatum;;
	private String titel;
	private String beschreibung;
	private int arbeitszeit;
	private int status;
	private int prio;
	private int aufgabenID;
	private int userID;
	
	public Aufgabe(){
		
	}
	
	public Aufgabe (String startDatum, String endDatum, String titel, String beschreibung, int arbeitszeit, int status, int prio, int userID)
	{
		this.startDatum = startDatum;
		this.endDatum = endDatum;
		this.titel = titel;
		this.beschreibung = beschreibung;
		this.arbeitszeit = arbeitszeit;
		this.status = status;
		this.prio = prio;
		this.userID = userID; // Als Setter
	}
	
	public String getStartDatum () {
		return this.startDatum;
	}
	public void setStartDatum (String startdatum)
	{
		this.startDatum = startdatum;
	}
	public String getEndDatum () {
		return this.endDatum;
	}
	public void setEndtDatum (String enddatum)
	{
		this.endDatum = enddatum;
	}
	public String getTitel ()
	{
		return this.titel;
	}
	public void setTitel (String titel)
	{
		this.titel = titel;
	}
	public String getBeschreibung ()
	{
		return this.beschreibung;
	}
	public void setBeschreibung (String beschreibung)
	{
		this.beschreibung = beschreibung;
	}
	public int getArbeitszeit ()
	{
		return this.arbeitszeit;
	}
	public void setArbeitszeit (int arbeitszeit)
	{
		this.arbeitszeit = arbeitszeit;
	}
	public int getStatus ()
	{
		return this.status;
	}
	public void setStatus (int status)
	{
		this.status = status;
	}
	public int getPrio ()
	{
		return this.prio;
	}
	public void setPrio (int prio)
	{
		this.prio = prio;
	}
	public int getAufgabenID ()
	{
		return this.aufgabenID;
	}
	public int getUserID ()
	{
		return this.userID;
	}
}
