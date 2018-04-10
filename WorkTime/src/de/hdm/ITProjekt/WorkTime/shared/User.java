package de.hdm.ITProjekt.WorkTime.shared;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String vorname;
	private String email;
	private String passwort;
	private Date letzterLogintest;
	private int typ;
	private int plz;

	public User() {

	}

	public User(String name, String vorname, String email, String passwort, Date letzterLogin) {
		this.name = name;
		this.vorname = vorname;
		this.email = email;
		this.passwort = passwort;
		this.letzterLogin = letzterLogin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ = typ;
	}

	public Date getLetzterLogin() {
		return letzterLogin;
	}

	public void setLetzterLogin(Date letzterLogin) {
		this.letzterLogin = letzterLogin;
	}

}
