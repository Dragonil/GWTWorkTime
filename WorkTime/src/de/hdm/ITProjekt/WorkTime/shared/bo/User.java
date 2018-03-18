package de.hdm.ITProjekt.WorkTime.shared.bo;

import java.sql.Date;

public class User extends BusinessObject {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String vorname;
	private String name;	
	private String email;
	private String passwort;	
	private Date letzterLogin;	
	private int typ;
	
	
	public User() {
		
	}
	
	public User(int id) {
		this.id = id;
	}
	
	public User (String firstName, String lastName) {
		this.vorname = firstName;
		this.name = lastName;
	}
	
	public User (int id, String firstName, String lastName, String passwort) {
		this.id = id;
		this.vorname = firstName;
		this.name = lastName;
		this.passwort = passwort;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return passwort;
	}
	
	public void setPassword(String passwort) {
		this.passwort = passwort;
	}
	
	public Date getLetzterLogin() {
		return letzterLogin;
	}
	
	public void setLetzterLogin(Date date) {
		this.letzterLogin = date;
	}
	
	public int getType() {
		return typ;
	}
	
	public void setType(int type) {
		this.typ = type;
	}
	
	public String getFirstName() {
		return name;
	}

	public void setFirstName(String firstName) {
		this.vorname = firstName;
	}

	public String getLastName() {
		return name;
	}

	public void setLastName(String lastName) {
		this.name = lastName;
	}
	
	

	@Override
	public String toString() {
		return "User [Vorname=" + vorname + ", Nachname=" + name + "]";
	}
	
}
