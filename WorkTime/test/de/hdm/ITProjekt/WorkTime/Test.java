package de.hdm.ITProjekt.WorkTime;

import java.util.Date;

import de.hdm.ITProjekt.WorkTime.server.datenbank.AufgabenMapper;
import de.hdm.ITProjekt.WorkTime.server.datenbank.NotizMapper;
import de.hdm.ITProjekt.WorkTime.server.datenbank.UserMapper;
import de.hdm.ITProjekt.WorkTime.shared.*;

public class Test {

	public static void main(String[] args) {
		
		// Test UserMapper
		 User u1 = new User("Oli", "Gorges", "og016@hdm-stuttgart.de", "1234", new Date());
		 User u2 = new User("Marco", "Pracher", "mp127@hdm-stuttgart.de", "abcde", new Date());
		 
		 UserMapper.insert(u1);
		 UserMapper.insert(u2);
		 UserMapper.findAll();
		 UserMapper.delete(u1);
		 UserMapper.findAll();
		
		// Test AufgabenMapper
		 
		 Aufgabe a1 = new Aufgabe(new Date().toString(), new Date().toString(), "Klassen schreiben", "Mapperklassen fertig schreiben", 2, 1, 1, 0 );
		 Aufgabe a2 = new Aufgabe(new Date().toString(), new Date().toString(), "GWT Testen", "funtion der Webseite testen", 2, 1, 2, 0 );
		 AufgabenMapper.insert(a1);
		 AufgabenMapper.insert(a1);
		 AufgabenMapper.findAll();
		 AufgabenMapper.delete(a1);
		 AufgabenMapper.findAll();
		 
		// Test NotziMapper
		 
		 Notiz n1 = new Notiz("Test Notiz1", "FF0000");
		 Notiz n2 = new Notiz("Hello World!", "0000FF");
		 NotizMapper.Notizanlegen(n1);
		 NotizMapper.Notizanlegen(n2);
		 NotizMapper.findAll();
		 NotizMapper.loeschen(n1.getId());
		 NotizMapper.findAll();
		 
		 
	}

}
