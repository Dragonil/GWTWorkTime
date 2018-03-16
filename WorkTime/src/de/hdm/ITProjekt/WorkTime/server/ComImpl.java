package de.hdm.ITProjekt.WorkTime.server;

import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.client.ComService;
import de.hdm.ITProjekt.WorkTime.server.datenbank.AufgabenMapper;
import de.hdm.ITProjekt.WorkTime.server.datenbank.NotizMapper;
import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.Notiz;
import de.hdm.ITProjekt.WorkTime.shared.User;

public class ComImpl implements ComService{
	
	// Aufgabe
	

	public void insertAufgabe (Aufgabe a) {
		AufgabenMapper.insert(a);
	}
	
	public Aufgabe findAufgabebyID (String titel) {
		return AufgabenMapper.findbyID(titel);
	}
	
	public Vector<Aufgabe> findAllAufgaben () {
		return AufgabenMapper.findAll();
	}
	public void deleteAufgabe (Aufgabe a) {
		AufgabenMapper.delete(a);
	}
	public void updateAufgabe (Aufgabe a) {
		AufgabenMapper.update(a);
	}
	
	// Notiz

	public Vector<Notiz> findAllNotizen(){

	        return NotizMapper.findAll();//will R�ckgabewert
	    }

        public Notiz findNotizById(int id) {

            return NotizMapper.findById(id);
        }
        
        public void Notizloeschen(Notiz notiz) {

        	NotizMapper.Notizloeschen(notiz); //Void deshalb kein R�ckgabewert
        	    
        }
    	public void Notizanlegen(Notiz notiz){

	        NotizMapper.Notizanlegen(notiz);//Void deshalb kein r�ckgabewert
	    }

		//User
    	
		public Vector<User> findAllUsers() {
			// TODO Auto-generated method stub
			return null;
		}

		
		public User findUserByEmail(String email) {
			// TODO Auto-generated method stub
			return null;
		}

		
		public User findUserById(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		
		public void insertUser(User user) {
			// TODO Auto-generated method stub
			
		}

		
		public void deleteUser(User user) {
			// TODO Auto-generated method stub
			
		}

		
		public void deleteUser(int id) {
			// TODO Auto-generated method stub
			
		}

		public void updateUser(User user) {
			// TODO Auto-generated method stub
			
		}

		
		public User login(User u) {
			// TODO Auto-generated method stub
			return null;
		}
    
}
