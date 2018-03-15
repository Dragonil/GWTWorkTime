package de.hdm.ITProjekt.WorkTime.shared;

import java.sql.Date;

import de.hdm.ITProjekt.WorkTime.shared.bo.BusinessObject;

public class Aufgabe extends BusinessObject{
	
	private int id;
	private String beschreibung;
	private String titel;
	private Date startDatum;
	private Date endDatum;
	private int status;
	private int arbeitszeit;
	private int prio;
	
	
	
	public Aufgabe() {
		super();
	}
	
	
	public Aufgabe(int id, String beschreibung, String titel, Date startDatum, Date endDatum) {
		super();
		this.id = id;
		this.beschreibung = beschreibung;
		this.titel = titel;
		this.startDatum = startDatum;
		this.endDatum = endDatum;
	}

	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBeschreibung() {
		return beschreibung;
	}
	
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	public String getTitel() {
		return titel;
	}
	
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public Date getStartDatum() {
		return startDatum;
	}
	
	public void setStartDatum(Date startDatum) {
		this.startDatum = startDatum;
	}
	
	public Date getEndDatum() {
		return endDatum;
	}
	
	public void setEndDatum(Date endDatum) {
		this.endDatum = endDatum;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getArbeitszeit() {
		return arbeitszeit;
	}
	
	public void setArbeitszeit(int arbeitszeit) {
		this.arbeitszeit = arbeitszeit;
	}
	
	public int getPrio() {
		return prio;
	}
	
	public void setPrio(int prio) {
		this.prio = prio;
	}
	
	
	

}
