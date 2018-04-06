package de.hdm.ITProjekt.WorkTime.client;

import de.hdm.ITProjekt.WorkTime.shared.*;
import java.util.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Kanban {
	
	protected final ComServiceAsync asyncCom = GWT.create(ComService.class);
	
	public static Panel getPanel(){
		HorizontalPanel hp = new HorizontalPanel();
		VerticalPanel vp[] = new VerticalPanel[5];
		String label[] = {"Stack", "to Do", "in Progress", "Testing", "Done"};
		Vector<Aufgabe> Aufgaben = new Vector<Aufgabe>();
		
		hp.setWidth("100vw");
		getAufgaben(); // Aufruf des AsyncCallback
		
		for(int i = 0; i<5;i++){
			vp[i] = new VerticalPanel();
			DragPanel l = new DragPanel(false, true);
			vp[i].getElement().setId(""+i);
			l.add(new HTML("<h1>"+label[i]+"</h1>"));
			
			l.setSize("18vw", "80px");
			vp[i].add(l);
			/*
			// Beispiel Platzhalter für Aufgabencontainer
			for(int j = 0; j<3;j++){
				DragPanel p = new DragPanel(true, true);
				//p.addAufgabe(??);
				p.add(new Label("Aufgabe "+j+i));
				p.setSize("18vw", "100px");
				vp[i].add(p);
			}
			*/
			vp[i].setWidth("18vw");
			vp[i].setBorderWidth(1);
			hp.add(vp[i]);
		}
		
		// Kanbanboard mit den aufgaben aus dem Vector füllen. (z.B. über foreach Schleife) bsp. für Dragpanel siehe Zeile 29-35
		// Wenn die Aufgaben implementiert sind in die Klasse DragPanel schauen und bei iniDrop einen Kommentar entferen.
		
		return hp;
	}
	
	private static void getAufgaben(){
		/*
		 * AsyncCallback schreiben um alle Aufgaben aus der Datenbank zu bekommen und in den Vector zu speichern
		 * Bsp. siehe AsyncCallback beispielen aus WorkTime.java
		 */
	}

}
