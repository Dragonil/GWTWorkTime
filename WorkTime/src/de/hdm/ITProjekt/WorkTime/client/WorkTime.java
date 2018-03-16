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
	
	protected static int currentModule = 1;
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
		case 2: p = Dashboard(); break;
		case 3: p = neueAufgabe(); break;
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
	private static Panel neueAufgabe(){
		VerticalPanel vp = new VerticalPanel();
		
		
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
				//Window.alert(titel.getText()+ " \n Date: "+date.getTextBox().getText() );
				dialog = new DialogBox();
				dialogPanel = new VerticalPanel();
				
				dialog.setAnimationEnabled(true);
				
				
				dialogPanel.add(new HTML("<h1>Neue Aufgabe</h1>"));
				dialogPanel.add(new HTML("<h2>"+titel.getText()+"</h2><div>"+beschreibung.getText()+"<br />"+
								date.getTextBox().getText()+"<br /> Prio: "+ 
								prio.getSelectedItemText()+"<br /></div><br />"));
				dialogPanel.add(close);
				dialog.add(dialogPanel);
				dialog.show();

				close.addClickHandler(new ClickHandler(){
					public void onClick(ClickEvent e){
						dialog.hide();
					}
				});
			}
		});
		
		return vp;
	}
	
	private static Panel Dashboard(){
		VerticalPanel vp = new VerticalPanel();
		HorizontalPanel hp = new HorizontalPanel();
		FocusPanel nav[] = {new FocusPanel(new HTML("NaviBox1")), new FocusPanel(new HTML("NaviBox2")), new FocusPanel(new HTML("NaviBox3"))};

		hp.addStyleName("naviDiv");
		for(FocusPanel p : nav) {
			
			p.addStyleName("naviElement");
			p.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent e){
					Window.alert(e.toString());
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
