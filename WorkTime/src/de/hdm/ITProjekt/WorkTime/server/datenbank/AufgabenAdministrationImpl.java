package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.Date;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.ITProjekt.WorkTime.shared.AufgabenAdministration;
import de.hdm.ITProjekt.WorkTime.shared.bo.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.bo.Notiz;
import de.hdm.ITProjekt.WorkTime.shared.bo.User;



public class AufgabenAdministrationImpl extends RemoteServiceServlet implements AufgabenAdministration {
	
	 public static final int DEFAULT_CASH_ACCOUNT_ID = 10000;

	  private User user = null;

	  private AufgabeMapper aMapper = null;
	  private NotizMapper nMapper = null;
	  private UserMapper uMapper = null;
	 
	  
	  public AufgabenAdministrationImpl() throws IllegalArgumentException {
	   
	  }
	  
	  /*
	   * Instanzen generieren
	   */

	  @Override
	  public void init() throws IllegalArgumentException {
	  
	    this.aMapper = AufgabeMapper.aufgabeMapper();
	    this.nMapper = NotizMapper.notizMapper();  
	    this.uMapper = UserMapper.userMapper();
	  
	 }
	  
	  // =============== Nutzer ===============
 	  
	  /* Neuen Nutzer im System anlegen */

	  public User createUser(String vorname, String nachname, String email) throws IllegalArgumentException {
		  User pers = uMapper.findByEmail(email);
			if (pers != null) {
				return pers;
			} 
			
		User u = new User();
	    u.setFirstName(vorname);
	    u.setLastName(nachname);
	    u.setId(1);
	    return this.uMapper.insert(u);			
	  }
	  
	  
	  @Override
		public User createUser(String vorname, String nachname) throws IllegalArgumentException {
			User u = null;
			if (vorname != null && nachname != null) {
				u = new User();
				u.setFirstName(vorname);
				u.setLastName(nachname);
				uMapper.insert(u);
			}
			return u;
		}
	  
	  
	  /* Nutzer speichern */
	  
	  public void save(User u) throws IllegalArgumentException {
		    uMapper.update(u);
	  }
	  
	  
	  /* Nutzer Methoden */
	  
		public User findPersonByEmail(String email) {
			return uMapper.findByEmail(email);
		}

		public User findPersonById(int id) {
			return uMapper.findById(id);
		}

		public Vector<User> findAllPersons() {
			return uMapper.findAll();
		}
		
		
	  /* Nutzer aus dem System löschen */
	  
	 
	public void delete(User u) throws IllegalArgumentException {
		
		    Vector<Aufgabe> tasks = this.getAllTasks();

		    if (tasks != null) {
		      for (Aufgabe task : tasks) {
		    
		        this.delete(task);
		      }
		    }

		    // Anschließend User entfernen
		    this.uMapper.delete(u);
		  }
	 
		
	// =============== Aufgabe ===============	
	
		
	private Vector<Aufgabe> getAllTasks() {
		return this.findAllTasks();
	}

	public Aufgabe createAufgabe(String beschreibung, String titel) throws IllegalArgumentException {
			
		Aufgabe a = null;
			if (titel != null && beschreibung != null) {
				a = new Aufgabe();
				a.setBeschreibung(beschreibung);
				a.setTitel(titel);
				aMapper.insert(a);
			}
			return a;
		}
	  
	public Vector <Aufgabe> findAllTasks() throws IllegalArgumentException {
			return this.aMapper.findAll();
		}

	public Vector <Aufgabe> findAllLatestFirst() throws IllegalArgumentException {
			Vector<Aufgabe> tasks = this.aMapper.findAll();
			tasks.sort(null);
			return tasks;
		}

	public Aufgabe findAufgabeById(int id) throws IllegalArgumentException{
			return aMapper.findByKey(id);
		}
	
	public Aufgabe findByKey(int id) throws IllegalArgumentException {
		return aMapper.findByKey(id);
	}
	  
	
	public void save(Aufgabe a) throws IllegalArgumentException {
	    aMapper.update(a);
	  }
	
	public void delete(Aufgabe a) throws IllegalArgumentException {
	    Vector<Aufgabe> tasks = this.getAllTasks();    
	    Vector<Notiz> notes = new Vector<Notiz>();

	    if (a != null) {
	      for (Aufgabe task : tasks) {
	    	
	    	if(task.getNotizen() != null) {
	    	notes = task.getNotizen();	    	
	    	
	    			for(Notiz note : notes)
	    			this.nMapper.delete(note);
	    	
	    	}
	    	
	        this.aMapper.delete(a);
	        
	      }
	      
	    }

	    // Anschließend Aufgabe entfernen
	    this.aMapper.delete(a);
	  }
	
	
	//===Notizen===
	  
	   /* Auslesen sämtlicher Notizen einer Aufgabe */
	
	  public Vector<Notiz> getAllNotes(Aufgabe a) throws IllegalArgumentException {
	    return this.nMapper.findByTask(a);
	  }
 
	  /**
	   * Auslesen des Notizen mit einer bestimmten Id
	   */
	  public Notiz getNotesById(int id) throws IllegalArgumentException {
		  return nMapper.findByKey(id);
	  }

	 
	  public void delete(Notiz note) throws IllegalArgumentException {
	    this.nMapper.delete(note);
	  }



	@Override
	public Vector<Aufgabe> findAll() throws IllegalArgumentException {
		return aMapper.findAll();
	}

	@Override
	public Aufgabe findByTitel(String titel) throws IllegalArgumentException{
		return aMapper.findByTitel(titel);
	}

	@Override
	public Aufgabe insert(Aufgabe a) throws IllegalArgumentException{
		return aMapper.insert(a);
	}

	@Override
	public Aufgabe update(Aufgabe a) throws IllegalArgumentException{
		return aMapper.update(a);
	}

	@Override
	public Vector<Notiz> findByDate(Date datum) throws IllegalArgumentException{
		return nMapper.findByDate(datum);
	}

	@Override
	public Vector<Notiz> findByTask(Aufgabe a) throws IllegalArgumentException{
		return nMapper.findByTask(a);
	}

	@Override
	public Notiz insert(Notiz c) throws IllegalArgumentException{
		return nMapper.insert(c);
	}

	@Override
	public Notiz update(Notiz c) throws IllegalArgumentException{
		return nMapper.update(c);
	}

	@Override
	public Vector <User> findByLastName(String name) throws IllegalArgumentException{
		return this.uMapper.findByLastName(name);
	}

	@Override
	public User insert(User u) throws IllegalArgumentException{
		return this.uMapper.insert(u);
	}

	@Override
	public User update(User u) throws IllegalArgumentException{
		return this.uMapper.update(u);
	}

	
	

	@Override
	public Notiz createNotiz(String inhalt, Date datum) throws IllegalArgumentException{
		Notiz u = null;
		if (inhalt != null && datum != null) {
			u = new Notiz();
			u.setInhalt(inhalt);
			u.setDatum(datum);
			nMapper.insert(u);
		}
		return u;
	}

	@Override
	public Aufgabe findById(int id) throws IllegalArgumentException{
		return this.aMapper.findByKey(id);
	}

	@Override
	public User findByUserId(int id) throws IllegalArgumentException{
		return this.uMapper.findById(id);
	}

	

	


}

