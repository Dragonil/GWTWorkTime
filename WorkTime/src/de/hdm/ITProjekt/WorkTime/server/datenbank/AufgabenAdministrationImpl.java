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
	 
	  
	  public AufgabenAdministrationImpl() throws IllegalArgumentException {
	   
	  }
	  
	  /*
	   * Instanzen generieren
	   */

	  @Override
	  public void init() throws IllegalArgumentException {
	  
	    this.aMapper = AufgabeMapper.aufgabeMapper;
	    this.nMapper = NotizMapper.notizMapper;  
	  
	 }
	  
	  // =============== Nutzer ===============
 	  
	  /* Neuen Nutzer im System anlegen */

	  @Override
	  public User createUser(String vorname, String nachname, String email) throws IllegalArgumentException {
		  User pers = UserMapper.findByEmail(email);
			if (pers != null) {
				return pers;
			} 
			
		User u = new User();
	    u.setFirstName(vorname);
	    u.setLastName(nachname);
	    u.setId(1);
	    return this.uMapper.insert(c);			
	  }
	  
	  /* Nutzer speichern */
	  
	  @Override
		public void save(User u) throws IllegalArgumentException {
		    aMapper.update(u);
	  }
	  
	  
	  /* Nutzer Methoden */
	  
		public User findPersonByEmail(String email) {
			return UserMapper.findByEmail(email);
		}

		public User findPersonById(int id) {
			return UserMapper.findById(id);
		}

		public Vector<User> findAllPersons() {
			return UserMapper.findAll();
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
		    this.aMapper.delete(u);
		  }
	 
		
	// =============== Aufgabe ===============	
		
	public Aufgabe createAufgabe(String beschreibung, String titel) {
			Aufgabe kom = null;
			if (titel != null && beschreibung != null) {
				kom = new Aufgabe(beschreibung, titel);
				AufgabeMapper.insert(kom);
			}
			return kom;
		}
	  
	public Vector <Aufgabe> findAll() throws IllegalArgumentException {
			return this.aMapper.findAll();
		}

	public Vector <Aufgabe> findAllLatestFirst() {
			Vector<Aufgabe> tasks = findAll();
			tasks.sort(null);
			return tasks;
		}

	public Aufgabe findAufgabeById(int id) {
			return aMapper.findById(id);
		}

	  
	
	public void save(Aufgabe a) throws IllegalArgumentException {
	    aMapper.update(a);
	  }
	
	public void delete(Aufgabe a) throws IllegalArgumentException {
	    Vector<Aufgabe> tasks = this.getAllTasks();
	    

	    if (a != null) {
	      for (Aufgabe task : tasks) {
	    
	        this.delete(a);
	      }
	    }

	    // Anschließend Aufgabe entfernen
	    this.aMapper.delete(a);
	  }
	
	  /**
	   * Auslesen sämtlicher Notizen einer Aufgabe
	   */
	  @Override
	public Vector<Notiz> getAllNotes(Aufgabe a) throws IllegalArgumentException {
	    return this.aMapper.findByTask(a);
	  }
 
	  /**
	   * Auslesen des Notizen mit einer bestimmten Id
	   */
	  @Override
	public Notiz getNotesById(int id) throws IllegalArgumentException {
		  return nMapper.findByKey(id);
	  }

	 
	  @Override
	public void delete(Notiz note) throws IllegalArgumentException {
	 
	    // Account aus der DB entfernen
	    this.aMapper.delete(a);
	  }

	  /**
	   * Speichern eines Kontos.
	   */
	  @Override
	public void save(Aufgabe a) throws IllegalArgumentException {
	    aMapper.update(a);
	  }


}

