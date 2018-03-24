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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login {

	private static TextBox email = new TextBox();
	private static PasswordTextBox passwort = new PasswordTextBox();
	private static Button login = new Button("Login");

	public static Panel getPanel(){
		email.setStyleName("Textbox");
		passwort.setStyleName("Textbox");
		
		email.setSize("18em","25px");
		passwort.setWidth("18em");
		//Debug
		passwort.setText("1234");
		email.setText("og016@hdm-stuttgart.de");
		
		VerticalPanel vp = new VerticalPanel();
		VerticalPanel hp = new VerticalPanel();
		hp.setStyleName("Center");
		Image logo = new Image("Logo.png");
		
		
		vp.setStyleName("Center");
		vp.add(new HTML("<h1>Login</h1>"));
		vp.add(new HTML("<Label>EMail:</Label>"));
		vp.add(email);
		vp.add(new HTML("<Label>Passwort:</Label>"));
		vp.add(passwort);
		vp.add(login);
		
		hp.add(logo);
		hp.add(vp);
		return hp;
	}
	
	
	public static String getEmail(){
		return email.getText();
	}
	public static String getPasswort(){
		return passwort.getText();
	}
	public static Button getButton(){
		return login;
	}
}
