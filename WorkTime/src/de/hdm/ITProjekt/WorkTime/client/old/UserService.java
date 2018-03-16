package de.hdm.ITProjekt.WorkTime.client;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.ITProjekt.WorkTime.shared.User;


public interface UserService extends RemoteService {
	Vector <User> findAll();
	User findByEmail(String email);
	User findById(int id);
	void insert(User user);
	void delete(User user);
	void delete(int id);
	void update(User user);
	User login(User u);
}
