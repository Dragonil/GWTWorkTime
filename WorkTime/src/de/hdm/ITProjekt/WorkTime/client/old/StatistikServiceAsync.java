package de.hdm.ITProjekt.WorkTime.client;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.ITProjekt.WorkTime.shared.Notiz;

public interface StatistikServiceAsync {

	void Notizanlegen(Notiz notiz, AsyncCallback<Void> callback);
	void Notizloeschen(Notiz notiz, AsyncCallback<Void> callback);
	void findById(int id, AsyncCallback<Notiz> callback);
	void findAll(AsyncCallback<Vector<Notiz>> callback);
}
