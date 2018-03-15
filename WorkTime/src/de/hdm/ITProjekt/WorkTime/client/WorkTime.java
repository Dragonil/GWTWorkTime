package de.hdm.ITProjekt.WorkTime.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;


public class WorkTime implements EntryPoint {
	
	int currentModule = 1;
	DateBox date = new DateBox();

	public void onModuleLoad() {
		
		
		Panel p = null;
		switch(currentModule){
		case 1: p = Login(); break;
		case 2: p = Kanban(); break;
		}
		

		RootPanel.get("content").add(p);
	}
	
	public Panel Login(){
		VerticalPanel vp = new VerticalPanel();
		TextBox email = new TextBox();
		TextBox password = new TextBox();
		Button login = new Button("Login");
		
		login.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent e){
				currentModule++;
				onModuleLoad();
			}
		});
		
		vp.add(new HTML("<Label>EMail:</Label>"));
		vp.add(email);
		vp.add(new HTML("<Label>Passwort:</Label>"));
		vp.add(password);
		vp.add(login);
		return vp;
	}
	
	public Panel Kanban(){
		VerticalPanel vp = new VerticalPanel();
		TextBox titel = new TextBox();
		TextArea beschreibung = new TextArea();
		
		ListBox prio = new ListBox();
		prio.addItem("1"); // Sehr Wichtig
		prio.addItem("2"); // Wichtig
		prio.addItem("3"); // Unwichtig
		
		Button neu = new Button("Neu");
	
		vp.add(new HTML("<h1> Neue Aufgabe </h1>"));
		vp.add(titel);
		vp.add(beschreibung);
		vp.add(date);
		vp.add(prio);
		vp.add(neu);
		
		neu.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent e){
				Window.alert("Date: "+date.getTextBox().getText());
				/*
				DialogBox dialog = new DialogBox();
				dialog.setAnimationEnabled(true);
				dialog.add(new HTML("<h1>"+titel.getText()+"</h1>"));
				dialog.add(new HTML("<div>"+beschreibung.getText()+"<br />"));
				//dialog.add(new HTML(date.getLastDate()+"<br />"));
				//dialog.add(new HTML("Prio: " +prio.getSelectedItemText()+"<br /></div>"));
				vp.add(dialog);
				*/
			}
		});
		
		return vp;
	}
}
