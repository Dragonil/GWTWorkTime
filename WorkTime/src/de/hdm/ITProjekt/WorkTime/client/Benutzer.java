package de.hdm.ITProjekt.WorkTime.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt.WorkTime.shared.User;

public class Benutzer {
	
	
	
	public static Panel getPanel() {
		VerticalPanel vp = new VerticalPanel();
		vp.add(new HTML("<h1>Benutzer</h1>"));
		if(WorkTime.eingeloggterUser != null){
			User u = WorkTime.eingeloggterUser;
			/*
			 * 
			 * Aufgabe: alle Nutzerdaten von WorkTime.eingeloggterUser Anzeigen
			 * 
			 */
		}
		
		
		return vp;
	}
}
