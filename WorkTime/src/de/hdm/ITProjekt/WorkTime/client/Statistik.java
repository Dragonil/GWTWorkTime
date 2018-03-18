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

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;


public class Statistik {
	
	private static VerticalPanel HauptPanel = new VerticalPanel();
	private static FlexTable fp = new FlexTable();
	private static Button Button = new Button ("aktualisieren");
	private static Label Label = new Label ();
	//Daten in Tabelle einf�gen
	//private ArrayList<String> stocks = new ArrayList<String>();
	
	public static Panel getPanel() {
		//Beschriftung der Tabelle
		
				
				fp.setText(0, 0, "Offene Aufgaben");
				fp.setText(0, 1, "ben\\u00F6tigte Arbeitszeit");
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
			    fp.getRowFormatter().addStyleName(0, "watchListHeader");	    //Formatierung Zeile 0!
			    
			      
			      
			 


			      
			   /*   // Add a button that will add more rows to the table
			      Button addRowButton = new Button("Add a Row"); 
			      addRowButton.addClickHandler(new ClickHandler() {
			         @Override
			         public void onClick(ClickEvent event) {
			            addRow(fp);
			         }
			       //  addRowButton.addStyleName("Button");


					private void addRow(FlexTable fp) {
						// TODO Auto-generated method stub
						
					}
			      });*/
			      
			    /*  // Add a button that will remove more rows to the table
			      Button removeRowButton = new Button("Remove a Row"); 
			      removeRowButton.addClickHandler(new ClickHandler() {
			         @Override
			         public void onClick(ClickEvent event) {
			            removeRow(fp);
			         }
			        // removeRowButton.addStyleName("fixedWidthButton");
			        
					private void removeRow(FlexTable fp) {
						// TODO Auto-generated method stub
						
					}
			      });*/
				
				//RootPanel-> HTML-Seite?
				
				
				//Label-Text (unten)
				Label.setText("");
				
				//Widgets anordnen
				HauptPanel.add(fp);
				HauptPanel.add(Button);
				HauptPanel.add(Label);
				
				return HauptPanel;
				
		}
	
		public void addData(Aufgabe a){
			int count = fp.getRowCount();
			fp.setText(count +1 , 0, a.getTitel());
			fp.setText(count +1 , 1, a.getArbeitszeit()+"");
		}
		
		public Button getButton(){
			return Button;
			
		}
	

	}


