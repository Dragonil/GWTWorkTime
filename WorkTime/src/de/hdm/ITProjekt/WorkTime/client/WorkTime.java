package de.hdm.ITProjekt.WorkTime.client;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;


public class WorkTime implements EntryPoint {
	
	protected static int activeModule = 1;
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
		update();
	}
	
	public static void update() {
		
		//Window.alert("ActiveModule: "+activeModule);
		
		RootPanel.get("content").clear();
		Panel p = null;
		switch(activeModule){
		case 1: 	p = Login.getPanel(); break;
		case 2: {	p = Dashboard(Kanban.getPanel()); 
					//content = Kanban.getPanel(); 
					break;
				}
		case 3: {	p = Dashboard(Statistik.getPanel());
					//content = Statistik.getPanel();
					break;
				}
		case 4: p = Dashboard(new VerticalPanel());
		}
		

		RootPanel.get("content").add(p);
		//RootPanel.get("content").add(dialog);
	}
	/*
	private Panel Login(){
		VerticalPanel vp = new VerticalPanel();
		
		
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
	*/
	
	private static Panel Dashboard(Panel content){
		DockPanel dp = new DockPanel();
		VerticalPanel vp = new VerticalPanel();
		HorizontalPanel hp = new HorizontalPanel();
		FocusPanel nav[] = {new FocusPanel(new HTML("Kanban")), new FocusPanel(new HTML("Statistik")), new FocusPanel(new HTML("Profil"))};

		hp.setStyleName("naviDiv");
		
		
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
	
}
