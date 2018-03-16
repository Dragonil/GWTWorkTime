package de.hdm.ITProjekt.WorkTime.client;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;

public interface AufgabenServiceAsync {
	void insert (Aufgabe a, AsyncCallback <Void> callback);
	void findbyID (String titel, AsyncCallback <Aufgabe> callback);
	void findAll (AsyncCallback <Vector<Aufgabe>> callback);
	void delete (Aufgabe a,AsyncCallback <Void> callback);
	void update (Aufgabe a,AsyncCallback <Void> callback);
	

}
