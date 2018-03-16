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
	
	protected static int currentModule = 4;
	private static FlowPanel content = new FlowPanel(); // ContentPanel
	
	
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
		
		RootPanel.get("content").clear();
		Panel p = null;
		switch(currentModule){
		case 1: p = Login.getPanel(); break;
		case 4: p = Dashboard(); break;
		case 2: p = Kanban.getPanel(); break;
		case 3: p = Statistik.getPanel(); break;
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
	
	private static Panel Dashboard(){
		VerticalPanel vp = new VerticalPanel();
		HorizontalPanel hp = new HorizontalPanel();
		FocusPanel nav[] = {new FocusPanel(new HTML("NaviBox1")), new FocusPanel(new HTML("NaviBox2")), new FocusPanel(new HTML("NaviBox3"))};

		hp.addStyleName("naviDiv");
		for(FocusPanel p : nav) {
			
			p.addStyleName("naviElement");
			p.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent e){
					currentModule--;
					update();
				}
			});
			
			hp.add(p);
		}
		
		vp.add(hp);
		vp.add(new HTML("<h1>Test</h1>"));
		vp.add(content);
		return vp;
	}
	
}
