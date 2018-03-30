package de.hdm.ITProjekt.WorkTime.client.old;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.ITProjekt.WorkTime.shared.Notiz;

public interface StatistikService extends RemoteService {//durch RemoteService wei� er dass es den Async geben muss, ist f�r verbindung

	void Notizanlegen(Notiz notiz);
	void Notizloeschen(Notiz notiz);
	Notiz findById(int id);
	Vector<Notiz> findAll();
}

