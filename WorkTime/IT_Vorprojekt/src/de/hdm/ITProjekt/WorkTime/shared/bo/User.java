package de.hdm.ITProjekt.WorkTime.shared.bo;

import sun.util.calendar.BaseCalendar.Date;

public class User extends BusinessObject {

	private static final long serialVersionUID = 1L;
	
	private String firstName = "";

	private String lastName = "";
	
	private String email = "";

	private String passwort = "";
	
	private Date letzterLogin;
	
	private int typ;
	
	public User() {
		
	}
	
	public User (String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName; 
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}