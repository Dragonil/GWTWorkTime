package de.hdm.ITProjekt.WorkTime.client;

import java.util.Vector;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.ComService;
import de.hdm.ITProjekt.WorkTime.shared.ComServiceAsync;
import de.hdm.ITProjekt.WorkTime.shared.User;



public class WorkTime implements EntryPoint {
	
	protected final ComServiceAsync asyncCom = GWT.create(ComService.class);
	
	protected static int activeModule = 1; // Panel welches als erstes Angezeigt wird
	protected static User eingeloggterUser;
	//private static Panel content = new FlowPanel(); // ContentPanel
	
	
	// Aufgaben
	private static DateBox date = new DateBox();
	private static TextBox titel = new TextBox();
	private static TextArea beschreibung = new TextArea();	
	private static ListBox prio = new ListBox();
	
	
	// DialogBox
	private static DialogBox dialog;
	private static Button close = new Button("OK");
	private static VerticalPanel dialogPanel;

	public void onModuleLoad() {
		iniButtons(); // zu allen Buttons ClickListener hinzufügen
		update();	// Laden der Panels
	}
	
	public static void update() {
		
		
		RootPanel.get("content").clear();
		Panel p = null;
		// Panel Übersicht
		switch(activeModule){
		case 1: 	p = Login.getPanel(); break; // Login 
		case 2: {	p = Dashboard(Kanban.getPanel()); // Kanban
					break;
				}
		case 3: {	p = Dashboard(nAufgaben.getPanel()); // Aufgaben erstellen
					break;
				}
		case 4: p = Dashboard(Statistik.getPanel()); break;// Statistik
		case 5: p = Dashboard(Benutzer.getPanel()); break;// Statistik
		}
		

		RootPanel.get("content").add(p);
		
	}
	
	/*
	 * Navigations Elemente auf der Hauptseite
	 */
	
	private static Panel Dashboard(Panel content){
		DockPanel dp = new DockPanel();
		VerticalPanel vp = new VerticalPanel();
		HorizontalPanel hp = new HorizontalPanel();
		FocusPanel nav[] = {new FocusPanel(new HTML("Kanban")), new FocusPanel(new HTML("neue Aufgabe")), new FocusPanel(new HTML("Statistik")), new FocusPanel(new HTML("Benutzer"))};

		hp.setStyleName("naviDiv");
		//hp.add(new Image("Logo.png"));
		
		for(int i=0;i<nav.length; i++) {
			nav[i].setStyleName("naviElement");
			final int pos = i +2;
			nav[i].addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent e){
					activeModule = pos;
					update();
				}
			});
			
			hp.add(nav[i]);
		}
		vp.setStyleName("Center");
		vp.add(content);
		dp.add(hp, DockPanel.NORTH);
		dp.add(vp, DockPanel.CENTER);
		return dp;
	}
	
	/*
	 * 
	 * Sammlung aller ClickListener
	 * 
	 * Aufgabe:
	 * 	jedem Button einen ClickListener mit den passenden Funktionen zuweisen
	 * 
	 */
	
	public void iniButtons(){
		Login.getButton().addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent e){
				checkLoginDaten();
				//findAllUsers();
			}
		});

	   nAufgaben.senden.addClickHandler(new ClickHandler () { 
		   public void onClick (ClickEvent e ) {
			  aufgabeÜbertragen(nAufgaben.addRow());
			   
		   }
	   });
	   
	   /*
	    * ClickLisener für den Aktuallisieren Button der Statistik soll das Panel neu Laden => mathode update() aufrufen;
	    */
		
	}
	
	
	/*
	 * 
	 * Beispiel für einen AsyncCallback bei Login
	 * 
	 * 
	 * Aufgabe: weitere Async Callbacks schreiben um die Daten aus der Datenbank zu den Panels zu bekommen.
	 */
	
	private void checkLoginDaten(){
		User userLogin = new User();
		userLogin.setEmail(Login.getEmail());
		userLogin.setPasswort(Login.getPasswort());
		
		asyncCom.login(userLogin, new AsyncCallback<User>() {
			public void onFailure(Throwable error) {
				Window.alert("Datenbankfehler"+ error.getMessage());
			}
			// Erfolgreiche Abfrage der Server daten
			public void onSuccess(User result) {
				if (result != null) {
					eingeloggterUser = result;
					activeModule = 2;
					Window.alert("Eingeloggt");
					update();
				}else{
					Window.alert("Ihrer Logindaten sind falsch");
				}
				
			}
		});
		
	}
	
	private void findAllUsers(){
		
		
		asyncCom.findAllUsers( new AsyncCallback<Vector<User>>(){
			public void onFailure(Throwable error) {
				Window.alert("Datenbankfehler"+ error.getMessage());
				
			}
			
			@Override
			public void onSuccess(Vector<User> result) {
				// TODO Auto-generated method stub
				for(User u : result){
					Window.alert(u.getName());
					activeModule = 2;
				}
				
			}
		});
	}
	// Aufruf der AsyncMethode insertAufgabe()
	private void aufgabeÜbertragen(Aufgabe a){
		asyncCom.insertAufgabe(a, new AsyncCallback<Void>(){
			public void onFailure(Throwable error) {
				Window.alert("Datenbankfehler"+ error.getMessage());
				
			}
			
			@Override
			public void onSuccess(Void a) {
				// TODO Auto-generated method stub
				Window.alert("Aufgabe übertragen");
				
			}
		});
	}
}
