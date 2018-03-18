package de.hdm.ITProjekt.WorkTime.shared;

import java.sql.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.ITProjekt.WorkTime.shared.bo.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.bo.Notiz;
import de.hdm.ITProjekt.WorkTime.shared.bo.User;

public interface AufgabenAdministrationAsync{

	
	void findById(int id, AsyncCallback <Aufgabe> callback);
	
	void findAll(AsyncCallback <Vector<Aufgabe>> callback);
	
	void findByTitel(String titel, AsyncCallback <Vector<User>> callback);
	
	void insert(Aufgabe a, AsyncCallback <Aufgabe> callback);
	
	void update(Aufgabe a, AsyncCallback <Aufgabe> callback);
	
	void delete(Aufgabe a, AsyncCallback <Void> callback);
	
	void findById(int id, AsyncCallback <Notiz> callback);
	
	void findAll(AsyncCallback <Vector<Notiz>> callback);
	
	void findByDate(Date datum, AsyncCallback <Vector<Notiz>> callback);
	
	void findByTask(Aufgabe a, AsyncCallback <Vector<Notiz>> callback);
	
	void insert(Notiz c, AsyncCallback <Notiz> callback);
	
	void update(Notiz c, AsyncCallback <Notiz> callback);
	
	void delete(Notiz c, AsyncCallback <Void> callback);
	
	void findById(int id, AsyncCallback <User> callback);
	
	void findAll(AsyncCallback <Vector<User>> callback);
	
	void findByLastName(String name, AsyncCallback <Vector<User>> callback);
	
	void insert(User u, AsyncCallback <User> callback);
	
	void update(User u, AsyncCallback <User> callback);
	
	void delete(User u, AsyncCallback <Void> callback);
	
	void createUser(String vorname, String nachname, AsyncCallback <User> callback);
	
	void createNotiz(String inhalt, Date datum, AsyncCallback <Notiz> callback);
	
	void createAufgabe(String beschreibung, String titel, AsyncCallback <Aufgabe> callback);
	
	
}
