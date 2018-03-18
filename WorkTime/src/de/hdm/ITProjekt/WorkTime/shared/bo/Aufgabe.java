package de.hdm.ITProjekt.WorkTime.shared.bo;

import java.sql.Date;

public class Aufgabe extends BusinessObject{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String beschreibung;
	private String titel;
	private Date startDatum;
	private Date endDatum;
	private int status;
	private int arbeitszeit;
	private int prio;
	private Vector <Notiz> notizliste;
	private User verantwortlicher;
	
	
	
	public Aufgabe() {
		super();
	}
	
	public Aufgabe(String beschreibung, String titel, User verantwortlicher) {
		super();
		this.beschreibung = beschreibung;
		this.titel = titel;
		this.verantwortlicher = verantwortlicher;
	}
	
	public Aufgabe(int id, String beschreibung, String titel) {
		super();
		this.id = id;
		this.beschreibung = beschreibung;
		this.titel = titel;
	}


	public Aufgabe(int id, String beschreibung, String titel, Date startDatum, Date endDatum) {
		super();
		this.id = id;
		this.beschreibung = beschreibung;
		this.titel = titel;
		this.startDatum = startDatum;
		this.endDatum = endDatum;
	}

	
	public User getVerantwortlicher() {
		return verantwortlicher;
	}
	
	public void setVerantwortlicher(User verantwortlicher) {
		this.verantwortlicher = verantwortlicher;
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
	
	public Vector <Notiz> getNotizen(){
		return notizliste;
	}
	
	public void setNotiz(Notiz note) {
		if(note != null) {
		notizliste.addElement(note);
	}
	}


	@Override
	public String toString() {
		return "Aufgabe [id=" + id + ", beschreibung=" + beschreibung + ", titel=" + titel + ", startDatum="
				+ startDatum + ", endDatum=" + endDatum + ", status=" + status + ", arbeitszeit=" + arbeitszeit
				+ ", prio=" + prio + "]";
	}


	
	
	
	

}

