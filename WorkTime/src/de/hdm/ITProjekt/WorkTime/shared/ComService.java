package de.hdm.ITProjekt.WorkTime.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.Notiz;
import de.hdm.ITProjekt.WorkTime.shared.User;

@RemoteServiceRelativePath("com")


public interface ComService extends RemoteService{

	// Aufgaben 
	
	void insertAufgabe (Aufgabe a);
	
	Aufgabe findAufgabebyID (String titel);
	
	Vector<Aufgabe> findAllAufgaben();
	
	void deleteAufgabe (Aufgabe a);
	
	void updateAufgabe (Aufgabe a);
	
	
	// User
	
	Vector <User> findAllUsers();
	
	User findUserByEmail(String email);
	
	User findUserById(int id);
	
	void insertUser(User user);
	
	void deleteUser(User user);
	
	void deleteUser(int id);
	
	void updateUser(User user);
	
	User login(User u);
	
	
	//Notizen
	
	void Notizanlegen(Notiz notiz);
	
	void Notizloeschen(Notiz notiz);
	
	Notiz findNotizById(int id);
	
	Vector<Notiz> findAllNotizen();
	
}
