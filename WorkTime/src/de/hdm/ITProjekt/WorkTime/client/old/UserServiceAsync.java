package de.hdm.ITProjekt.WorkTime.client;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.ITProjekt.WorkTime.shared.User;

public interface UserServiceAsync {
	
		void findAll(AsyncCallback <Vector<User>> callback);
		void findById(int Id, AsyncCallback <User> callback);
		void findByEmail(String email, AsyncCallback <User> calllback);
		void insert(User user, AsyncCallback <Void> callback);
		void delete(User user, AsyncCallback <Void> callback);
		void delete(int id, AsyncCallback <Void> callback);
		void update(User user, AsyncCallback <Void> callback);
		void login(User u, AsyncCallback <User> callback);


}
