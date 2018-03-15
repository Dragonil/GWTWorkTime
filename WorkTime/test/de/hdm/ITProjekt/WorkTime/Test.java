package de.hdm.ITProjekt.WorkTime;

import java.util.Date;

import de.hdm.ITProjekt.WorkTime.shared.*;

public class Test {

	public static void main(String[] args) {
		
		// Test UserMapper
		 User u1 = new User("", "", "", "", new Date());
		 User u2 = new User();
		
		
		// Test AufgabenMapper
		 Aufgabe a1 = new Aufgabe(new Date().toString(), new Date().toString(), "Klassen schreiben", "Mapperklassen fertig schreiben", 2, 1, 1, 0 );
		 Aufgabe a2 = new Aufgabe(new Date().toString(), new Date().toString(), "GWT Testen", "funtion der Webseite testen", 2, 1, 2, 0 );
		
		// Test NotziMapper
		 Notiz n1 = new Notiz("Test Notiz1", "FF0000");
		 Notiz n2 = new Notiz("Hello World!", "0000FF");
	}

}
