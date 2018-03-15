package de.hdm.ITProjekt.WorkTime.client;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;

import org.eclipse.jetty.security.LoginService;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login implements EntryPoint {

	protected TextBox email;
	protected TextBox passwort;
	protected Button login;

	@Override
	public void onModuleLoad() {

		VerticalPanel vp = new VerticalPanel();
		email = new TextBox();
		passwort = new TextBox();
		login = new Button();

		vp.add(email);
		vp.add(passwort);
		vp.add(login);

		RootPanel.get("content").add(vp);
	}
}
