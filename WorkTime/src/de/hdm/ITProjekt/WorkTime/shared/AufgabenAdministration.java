package de.hdm.ITProjekt.WorkTime.shared;

import java.sql.Date;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.ITProjekt.WorkTime.shared.bo.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.bo.Notiz;
import de.hdm.ITProjekt.WorkTime.shared.bo.User;


public interface AufgabenAdministration extends RemoteService {

	/* Aufgabe Methoden */
	
	public Aufgabe findTaskById(int id);
	
	public Vector <Aufgabe> findAllTasks();
	
	public Aufgabe findByTitel(String titel);
	
	public Aufgabe insert(Aufgabe a);
	
	public Aufgabe update(Aufgabe a);
	
	public void delete(Aufgabe a);
	
	/* Notiz Methoden */
	
	public Notiz findNoteById(int id);
	
	public Vector <Notiz> findAllNotes();
	
	public Vector <Notiz> findByDate(Date datum);
	
	public Vector <Notiz> findByTask(Aufgabe a);
	
	public Notiz insert(Notiz n);
	
	public Notiz update(Notiz n);
	
	public void delete(Notiz n);
	
	/* User Methoden */
	
	public User findUserById(int id);
	
	public Vector <User> findAllUser();
	
	public Vector <User> findByLastName(String name);
	
	public User insert(User u);
	
	public User update(User u);
	
	public void delete(User u);

	
	
	public User createUser(String vorname, String nachname);
	
	public Notiz createNotiz(String inhalt, Date datum);
	
	public Aufgabe createAufgabe(String beschreibung, String titel);

	
}

