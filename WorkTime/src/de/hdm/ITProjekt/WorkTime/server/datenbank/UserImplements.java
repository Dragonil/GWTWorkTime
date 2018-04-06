package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.shared.User;

public class UserImplements {

	public Vector<User> findAll() {
		return UserMapper.findAll();
	}

	public User findByEmail(String email) {
		return UserMapper.findByEmail(email);
	}

	public void insert(User user) {
	}

	public void delete(User user) {
	}

	public void delete(int id) {
	}

	public void update(User user) {
	}

	public User login(User u) {   //Vorher ...boolean login...   Aber Fehler aufgetreten
		return UserMapper.login(u);
	}

}
