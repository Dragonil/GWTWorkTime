package de.hdm.ITProjekt.WorkTime.shared.bo;

import sun.util.calendar.BaseCalendar.Date;

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
		return password;
	}
	
	public void setPassword() {
		this.passwort = passwort;
	}
	
	public Date getLetzterLogin() {
		return letzerLogin;
	}
	
	public void setLetzterLogin(Date letzterLogin) {
		this.letzterLogin = letzterLogin;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType() {
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
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
