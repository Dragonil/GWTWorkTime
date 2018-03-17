package de.hdm.ITProjekt.WorkTime.client;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;

import org.eclipse.jetty.security.LoginService;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login {

	private static TextBox email = new TextBox();
	private static TextBox passwort = new TextBox();
	private static Button login = new Button("Login");

	public static Panel getPanel(){
		
		
		//Debug
		passwort.setText("1234");
		
		VerticalPanel vp = new VerticalPanel();
		vp.setStyleName("Center");
		
		login.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent e){
				checkData();
				//Window.alert("Klick");
			}
		});
		
		vp.add(new HTML("<Label>EMail:</Label>"));
		vp.add(email);
		vp.add(new HTML("<Label>Passwort:</Label>"));
		vp.add(passwort);
		vp.add(login);
		return vp;
	}
	
	private static void checkData(){
		if(passwort.getText() == "1234"){
			WorkTime.activeModule = 2;
			WorkTime.update();
		}else{
			Window.alert("Falsches Passwort");
		}
	}
}
