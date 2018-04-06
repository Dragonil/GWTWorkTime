package de.hdm.ITProjekt.WorkTime.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.Notiz;
import de.hdm.ITProjekt.WorkTime.shared.User;


public interface ComServiceAsync {
	// Aufgaben 
	
		void insertAufgabe (Aufgabe a, AsyncCallback<Void> callback);
		
		void findAufgabebyID (String titel, AsyncCallback<Aufgabe> callback);
		
		void findAllAufgaben(AsyncCallback<Vector<Aufgabe>> callback);
		
		void deleteAufgabe (Aufgabe a, AsyncCallback<Void> callback);
		
		void updateAufgabe (Aufgabe a, AsyncCallback<Void> callback);
		
		
		// User
		
		void findAllUsers(AsyncCallback<Vector <User>> callback);
		
		void findUserByEmail(String email, AsyncCallback<User> callback);
		
		void findUserById(int id, AsyncCallback<User> callback);
		
		void insertUser(User user, AsyncCallback<Void> callback);
		
		void deleteUser(User user, AsyncCallback<Void> callback);
		
		void deleteUser(int id, AsyncCallback<Void> callback);
		
		void updateUser(User user, AsyncCallback<Void> callback);
		
		void login(User u, AsyncCallback<User> callback);
		
		
		//Notizen
		
		void Notizanlegen(Notiz notiz, AsyncCallback<Void> callback);
		
		void Notizloeschen(Notiz notiz, AsyncCallback<Void> callback);
		
		void findNotizById(int id, AsyncCallback<Notiz> callback);
		
		void findAllNotizen(AsyncCallback<Vector<Notiz>> callback);
}
