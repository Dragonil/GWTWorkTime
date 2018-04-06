package de.hdm.ITProjekt.WorkTime.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.DragLeaveEvent;
import com.google.gwt.event.dom.client.DragLeaveHandler;
import com.google.gwt.event.dom.client.DragOverEvent;
import com.google.gwt.event.dom.client.DragOverHandler;
import com.google.gwt.event.dom.client.DragStartEvent;
import com.google.gwt.event.dom.client.DragStartHandler;
import com.google.gwt.event.dom.client.DropEvent;
import com.google.gwt.event.dom.client.DropHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.hdm.ITProjekt.WorkTime.shared.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.ComService;
import de.hdm.ITProjekt.WorkTime.shared.ComServiceAsync;

public class DragPanel extends FocusPanel{
	protected final ComServiceAsync asyncCom = GWT.create(ComService.class);
	
	private static DragPanel dragging = null;
	final boolean droppable;
	private Aufgabe aufgabe;
	
	public DragPanel(boolean draggable, boolean droppable){
	   if (draggable) {
	     initDrag();
	   }
	   if (droppable) {
	     initDrop();
	   }
	   this.droppable = droppable;
	   if (droppable) {
	     addStyleName("droppable");
	   } else if (draggable) {
	     addStyleName("draggable");
	   }
	 }
	
	private void addAufgabe(Aufgabe a){
		this.aufgabe = a;
	}
	
	private void initDrag() {
		     getElement().setDraggable(Element.DRAGGABLE_TRUE);
		    
		    addDragStartHandler(new DragStartHandler() {
		     public void onDragStart(DragStartEvent event) {    
		       dragging = DragPanel.this;
		       event.setData("ID", "UniqueIdentifier");
		       event.getDataTransfer().setDragImage(getElement(), 10, 10);
		     }
		   });
		 }



	private void initDrop() {
		   addDomHandler(new DragOverHandler() {
		   @Override
		   public void onDragOver(DragOverEvent event) {
		     addStyleName("dropping");
		   }
		 }, DragOverEvent.getType());

		 addDomHandler(new DragLeaveHandler() {
		   @Override
		   public void onDragLeave(DragLeaveEvent event) {
		     removeStyleName("dropping");
		   }
		 }, DragLeaveEvent.getType());

		 addDomHandler(new DropHandler() {
		   @Override
		   public void onDrop(DropEvent event) {
		     event.preventDefault();
			     if (dragging != null) {
			    	 
			    	 VerticalPanel source = (VerticalPanel) dragging.getParent();
			    	 source.remove(dragging);
			    	
			    	 VerticalPanel targ = (VerticalPanel) DragPanel.this.getParent();
			    
			    	 targ.add(dragging);
			    	 //updateAufgabe(Integer.parseInt(targ.getElement().getId()));  erst Nutzen wenn Richtige Aufgaben vorhaben
				     dragging = null;
			     }
			}
		 }, DropEvent.getType());
	 }
	
	
	/*
	 * Async Callback um den Status der Aufgabe zu ändern
	 * 
	 */
	private void updateAufgabe(int status){
		aufgabe.setStatus(status);
		asyncCom.updateAufgabe(aufgabe, new AsyncCallback<Void>(){
			public void onFailure(Throwable error) {
				Window.alert("Datenbankfehler"+ error.getMessage());
			}
			
			@Override
			public void onSuccess(Void a) {
				// TODO Auto-generated method stub
				Window.alert("Status geändert");
				
			}
		});
	}
	


}
