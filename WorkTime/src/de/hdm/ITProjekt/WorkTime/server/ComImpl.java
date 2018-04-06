package de.hdm.ITProjekt.WorkTime.server;

import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.ITProjekt.WorkTime.shared.ComService;
import de.hdm.ITProjekt.WorkTime.server.datenbank.AufgabenMapper;
import de.hdm.ITProjekt.WorkTime.server.datenbank.NotizMapper;
import de.hdm.ITProjekt.WorkTime.server.datenbank.UserMapper;
import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.Notiz;
import de.hdm.ITProjekt.WorkTime.shared.User;

public class ComImpl extends RemoteServiceServlet implements ComService {

	/*
	 * 
	 * Aufgabe: Alle Methoden mit Inhalt füllen.
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public ComImpl() {

	}

	// Aufgabe
	public void insertAufgabe(Aufgabe a) {
		AufgabenMapper.insert(a);
	}

	public Aufgabe findAufgabebyID(String titel) {
		return AufgabenMapper.findbyID(titel);
	}

	public Vector<Aufgabe> findAllAufgaben() {
		return AufgabenMapper.findAll();
	}

	public void deleteAufgabe(Aufgabe a) {
		AufgabenMapper.delete(a);
	}

	public void updateAufgabe(Aufgabe a) {
		AufgabenMapper.update(a);
	}

	// Notiz

	public Vector<Notiz> findAllNotizen() {

		return NotizMapper.findAll();// will R�ckgabewert
	}

	public Notiz findNotizById(int id) {

		return NotizMapper.findById(id);
	}

	public void Notizloeschen(Notiz notiz) {

		NotizMapper.Notizloeschen(notiz); // Void deshalb kein R�ckgabewert

	}

	public void Notizanlegen(Notiz notiz) {

		NotizMapper.Notizanlegen(notiz);// Void deshalb kein r�ckgabewert
	}

	// User

	public Vector<User> findAllUsers() {

		return UserMapper.findAll();
	}

	public User findUserByEmail(String email) {

		return UserMapper.findByEmail(email);
	}

	public User findUserById(int id) {

		return UserMapper.findById(id);
	}

	public void insertUser(User user) {
		UserMapper.insert(user);

	}

	public void deleteUser(User user) {
		UserMapper.delete(user);

	}

	public void deleteUser(int id) {
		UserMapper.delete(id);

	}

	public void updateUser(User user) {
		UserMapper.update(user);

	}

	public User login(User u) {
		return UserMapper.login(u);
	}

}
