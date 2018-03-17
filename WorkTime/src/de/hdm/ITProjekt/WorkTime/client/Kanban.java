package de.hdm.ITProjekt.WorkTime.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Kanban {
	
	static TextBox titel = new TextBox();
	static TextArea besch = new TextArea();
	static DateBox date = new DateBox();
	static ListBox prio = new ListBox();
	static Button senden = new Button("Senden");
	static final FlexTable flexTable = new FlexTable();
	/**
	 * This is the entry point method.
	 */
	public static Panel getPanel() {
	
	    // Create a Flex Table
	      
			
		
	      //FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
	      flexTable.addStyleName("flexTable");
	      flexTable.setWidth("32em");
	      flexTable.setCellSpacing(5);
	      flexTable.setCellPadding(3);

	      // Add some text
	      /*
	      cellFormatter.setHorizontalAlignment(
	      0, 1, HasHorizontalAlignment.ALIGN_LEFT);
	      flexTable.setHTML(0, 0, "This is a FlexTable that supports"
	         +" <b>colspans</b> and <b>rowspans</b>."
	         +" You can use it to format your page"
	         +" or as a special purpose table.");
	         */
	      flexTable.setHTML(0, 0, "Titel");
	      flexTable.setHTML(0, 1, "Beschreibung");
	      flexTable.setHTML(0, 2, "Datum");
	      flexTable.setHTML(0, 3, "Priorität");
	      
	      // Add a button that will add more rows to the table
	      //Button addRowButton = new Button("Add a Row"); 
	      /*addRowButton.addClickHandler(new ClickHandler() {
	         @Override
	         public void onClick(ClickEvent event) {
	            addRow(flexTable);
	         }
	      });
			*/
	      //addRowButton.addStyleName("fixedWidthButton");

	      // Add a button that will add more rows to the table
	      Button removeRowButton = new Button("Remove a Row"); 
	      removeRowButton.addClickHandler(new ClickHandler() {
	         @Override
	         public void onClick(ClickEvent event) {
	            removeRow(flexTable);
	         }
	      });

	      removeRowButton.addStyleName("fixedWidthButton");

	      //VerticalPanel buttonPanel = new VerticalPanel();
	      //buttonPanel.setStyleName("flexTable-buttonPanel");
	      //buttonPanel.add(addRowButton);
	      //buttonPanel.add(removeRowButton);
	      //flexTable.setWidget(0, 1, buttonPanel);
	      //cellFormatter.setVerticalAlignment(0, 1, 
	      //HasVerticalAlignment.ALIGN_TOP);

	      // Add two rows to start
	      

	      // Add the widgets to the root panel.
	      DockPanel p = new DockPanel();
	      p.add(neueAufgabe(), DockPanel.WEST);
	      p.add(removeRowButton, DockPanel.SOUTH);
	      p.add(flexTable, DockPanel.CENTER);
	      
	      return p;
	      
	   }

	   /**
	    * Add a row to the flex table.
	    */
	   static private void addRow(FlexTable flexTable) {
	      int numRows = flexTable.getRowCount();
	      flexTable.setWidget(numRows, 0, new HTML(titel.getText()));
	      flexTable.setWidget(numRows, 1, new HTML (besch.getText()));
	      flexTable.setWidget(numRows, 2, new HTML (date.getTextBox().getText()));
	      flexTable.setWidget(numRows, 3, new HTML (prio.getSelectedItemText()));
	      //flexTable.getFlexCellFormatter().setRowSpan(1, 3,  numRows + 1);
	      
	   }

	   /**
	    * Remove a row from the flex table.
	    */
	   static private void removeRow(FlexTable flexTable) {
	      int numRows = flexTable.getRowCount();
	      if (numRows > 1) {
	         flexTable.removeRow(numRows - 1);
	         //flexTable.getFlexCellFormatter().setRowSpan(1, 3, numRows - 1);
	      }
	   }
	   
	   static public Panel neueAufgabe() {
		   Panel p = new VerticalPanel();

			prio.addItem("Sehr Wichtig"); // Sehr Wichtig
			prio.addItem("Wichtig"); // Wichtig
			prio.addItem("Unwichtig"); // Unwichtig
		   
		   
		   senden.addClickHandler(new ClickHandler () { 
			   public void onClick (ClickEvent e ) {
				   addRow(flexTable);
				   clearText();
			   }
		   });
		   p.add(new HTML("<label>Titel:</label>"));
		   p.add(titel);
		   p.add(new HTML("<label>Beschreibung:</label>"));
		   p.add(besch);
		   p.add(new HTML("<label>Enddatum:</label>"));
		   p.add(date);
		   p.add(new HTML("<label>Priorität:</label>"));
		   p.add(prio);
		   p.add(senden);
		   p.setStyleName("form");
		   return p;
	   }
	   
	   public static void clearText(){
		   titel.setText("");
		   besch.setText("");
		   date.getTextBox().setText("");
	   }
	   
		    
	}
