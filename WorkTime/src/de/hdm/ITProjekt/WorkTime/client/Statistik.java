package de.hdm.ITProjekt.WorkTime.client;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.ComService;
import de.hdm.ITProjekt.WorkTime.shared.ComServiceAsync;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;


public class Statistik {
	protected final ComServiceAsync asyncCom = GWT.create(ComService.class);
	
	private static VerticalPanel HauptPanel = new VerticalPanel();
	private static FlexTable fp = new FlexTable();
	private static Button Button = new Button ("aktualisieren");
	private static Label Label = new Label ();
	//Daten in Tabelle einf�gen
	//private ArrayList<String> stocks = new ArrayList<String>();
	
	public static Panel getPanel() {
		//Beschriftung der Tabelle
				
				
				
				fp.setText(0, 0, "Offene Aufgaben");
				fp.setText(0, 1, "benötigte Arbeitszeit");
				
				/*
				 * Aufgabe: Daten über AsyncCallback aus der Datenabk holen um die Tabellen zu befüllen 
				 * z.B. über eine foreach schleife und der Methode addData
				 */
				
				//fp.setText(1, 0, "1. Aufgabe");
				//fp.setText(1, 1, "1. Arbeitszeit");
				//fp.setText(2, 0, "2. Aufgabe");
				//fp.setText(2, 1, "2. Arbeitszeit");
				
				//Tabelle Ma�e
			   //  FlexCellFormatter cellFormatter = fp.getFlexCellFormatter();
			      fp.addStyleName("flexTable");//deshalb in css .flexTable
			      fp.setWidth("32em"); //Breite der Tabelle
			      fp.setCellSpacing(1);
			      fp.setCellPadding(5);
			      //fp.addCell(1);
			    //fp.setBorderWidth(100); //Gitter
			    fp.getRowFormatter().addStyleName(0, "watchListHeader");	    //Formatierung Zeil 0
				
				
				
				//Label-Text (unten)
				Label.setText("");
				
				//Widgets anordnen
				HauptPanel.add(fp);
				HauptPanel.add(Button);
				HauptPanel.add(Label);
				
				return HauptPanel;
				
		}
	
		public static void addData(Aufgabe a){
			int count = fp.getRowCount();
			fp.setText(count +1 , 0, a.getTitel());
			fp.setText(count +1 , 1, a.getArbeitszeit()+"");
		}
		
		public static Button getButton(){
			return Button;
			
		}
		
		public static void getAufgaben(){
			/*
			 * AsyncCallback um die Aufgaben aus der Datenbak zu erhalten bsp. siehe WorkTime.java
			 * Daten am besten über einen Vector an die Tabelle übertragen
			 */
		}
	

	}


