package de.hdm.ITProjekt.WorkTime.server.old;

import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.client.old.AufgabenService;
import de.hdm.ITProjekt.WorkTime.server.datenbank.AufgabenMapper;
import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;

public class AufgabenImplements implements AufgabenService {

	public void insert (Aufgabe a) {
		AufgabenMapper.insert(a);
	}
	
	public Aufgabe findbyID (String titel) {
		return AufgabenMapper.findbyID(titel);
	}
	
	public Vector<Aufgabe> findAll () {
		return AufgabenMapper.findAll();
	}
	public void delete (Aufgabe a) {
		AufgabenMapper.delete(a);
	}
	public void update (Aufgabe a) {
		AufgabenMapper.update(a);
	}





	
}
