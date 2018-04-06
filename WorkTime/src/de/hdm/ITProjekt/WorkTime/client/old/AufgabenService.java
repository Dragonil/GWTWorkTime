package de.hdm.ITProjekt.WorkTime.client.old;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;

public interface AufgabenService extends RemoteService {

	void insert (Aufgabe a);
	Aufgabe findbyID (String titel);
	Vector<Aufgabe> findAll ();
	void delete (Aufgabe a);
	void update (Aufgabe a);
	
	
}
