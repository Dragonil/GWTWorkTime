
package de.hdm.ITProjekt.WorkTime.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;



public class WorkTime implements EntryPoint { // Kanban
	
	
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()  {
			/*
		    DockLayoutPanel p = new DockLayoutPanel(Unit.EM);
		    p.addNorth(new HTML("north"), 2);
		    p.addSouth(new HTML("south"), 2);
		    p.addEast(new HTML("east"), 2);
		    p.addWest(new HTML("west"), 2);
		    p.add(new HTML("center"));

		    // Attach the LayoutPanel to the RootLayoutPanel. The latter will listen for
		    // resize events on the window to ensure that its children are informed of
		    // possible size changes.
		    RootLayoutPanel rp = RootLayoutPanel.get();
		    rp.add(p);
		    */
		
			RootPanel.get().add(Kanban.getPanel());
		  }
		
	}

