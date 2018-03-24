package de.hdm.ITProjekt.WorkTime.client;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Benutzer {
	
	public static Panel getPanel(){
		HorizontalPanel hp = new HorizontalPanel();
		VerticalPanel vp[] = new VerticalPanel[5];
		String label[] = {"Stack", "to Do", "in Progress", "Testing", "Done"};
		
		hp.setWidth("100vw");
		
		for(int i = 0; i<5;i++){
			vp[i] = new VerticalPanel();
			DragPanel l = new DragPanel(false, true);
			l.add(new HTML("<h1>"+label[i]+"</h1>"));
			l.setSize("18vw", "80px");
			vp[i].add(l);
			
			for(int j = 0; j<3;j++){
				DragPanel p = new DragPanel(true, true);
				p.add(new Label("Aufgabe "+j+i));
				p.setSize("18vw", "100px");
				vp[i].add(p);
			}
			vp[i].setWidth("18vw");
			vp[i].setBorderWidth(1);
			hp.add(vp[i]);
		}
		
		return hp;
	}

}
