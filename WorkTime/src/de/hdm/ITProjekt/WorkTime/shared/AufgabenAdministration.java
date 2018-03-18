package de.hdm.ITProjekt.WorkTime.shared;

public interface AufgabenAdministration extends RemoteService {

	/* Aufgabe Methoden */
	
	public Aufgabe findByKey(int id);
	
	public Vector <Aufgabe> findAll();
	
	public Aufgabe findByTitel(String titel);
	
	public Aufgabe insert(Aufgabe a);
	
	public Aufgabe update(Aufgabe a);
	
	public void delete(Aufgabe a);
	
	/* Notiz Methoden */
	
	public Notiz findByKey(int id);
	
	public Vector <Notiz> findAll();
	
	public Vector <Notiz> findByDate(Date datum);
	
	public Vector <Notiz> findByTask(Aufgabe a);
	
	public Notiz insert(Notiz c);
	
	public Notiz update(Notiz c);
	
	public void delete(Notiz c);
	
	/* User Methoden */
	
	public User findByKey(int id);
	
	public Vector <User> findAll();
	
	public Vector <User> findByLastName(String name);
	
	public User insert(User u);
	
	public User update(User u);
	
	public void delete(User u);

	
	
	public User createUser(String vorname, String nachname);
	
	public Notiz createNotiz(String inhalt, Date datum);
	
	public Aufgabe createAufgabe(String beschreibung, String titel);
	
}

