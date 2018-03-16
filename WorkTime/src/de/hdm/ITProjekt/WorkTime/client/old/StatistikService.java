package de.hdm.ITProjekt.WorkTime.client;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.ITProjekt.WorkTime.shared.Notiz;

public interface StatistikService extends RemoteService {//durch RemoteService weiß er dass es den Async geben muss, ist für verbindung

	void Notizanlegen(Notiz notiz);
	void Notizloeschen(Notiz notiz);
	Notiz findById(int id);
	Vector<Notiz> findAll();
}

