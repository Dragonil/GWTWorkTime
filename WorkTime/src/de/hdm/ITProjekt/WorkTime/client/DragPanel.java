package de.hdm.ITProjekt.WorkTime.client;

import java.util.ArrayList;
import java.util.List;

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
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class DragPanel extends FocusPanel{
	
	private static DragPanel dragging = null;
	final boolean droppable;

	
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
			    	//Window.alert(event.toString());
			    	
			    	 VerticalPanel targ = (VerticalPanel) DragPanel.this.getParent();
			    	 targ.add(dragging);
			    	 
			    	 /*
				     VerticalPanel target = null;
				     VerticalPanel source = null;
				     VerticalPanel main = (VerticalPanel) DragPanel.this.getParent();
				     List<Panel> Panels = new ArrayList<Panel>();
				     
				     while (main.getWidgetCount()>0) {
				    	 Panels.add((Panel) main.getWidget(0));
				    	 main.remove(0);
				        
				     }
			     
			   
				     if (source != null && target != null) {
				       VerticalPanel testTarget = target;
				       while (testTarget != null) {
				         if (testTarget == source) {
				           return;
				         }
				         testTarget = (VerticalPanel) testTarget.getParent();
				       }
				       target.add(source);
				     }
				     */
				     dragging = null;
			     }
			}
		 }, DropEvent.getType());
	 }
	
	


}
