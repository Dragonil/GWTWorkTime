package de.hdm.ITProjekt.WorkTime.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import de.hdm.ITProjekt.WorkTime.shared.AufgabenAdministration;
import de.hdm.ITProjekt.WorkTime.shared.AufgabenAdministrationAsync;


public class WorkTime implements EntryPoint {
	
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";
	
	//Proxy Objekt generieren
	private final AufgabenAdministrationAsync taskControll = GWT.create(AufgabenAdministration.class);
	
	private int counter;
	
	private VerticalPanel mainPanel = new VerticalPanel();
	private TextBox title = new TextBox();
	private TextBox untertitel = new TextBox();
	private TextArea inhalt = new TextArea();
	
	private Label titleLabel = new Label("Titel:");
	private Label untertitelLabel = new Label("Untertitel:");
	private Label inhaltLabel = new Label("Text:");
	private Label errorLabel = new Label();
	
	private Label html = new HTML("<h1>Neuer Blogeintrag Nr. " + counter + " anlegen </h1>");
	
	private Button saveBtn = new Button("Speichern");
	
	
	//Startmethode
	
		public void onModuleLoad() {
			
			//Zaehler aufrufen
			updateCounter();
			
			inhaltLabel.setWidth("40em");
			inhaltLabel.setHeight("10em");
			
			//Layout
			Grid fields = new Grid(5,2);
			fields.setWidget(0, 0, new HTML("<b>Eintrag</b>"));
			fields.setWidget(1, 0, titleLabel);
			fields.setWidget(1, 1, title);
			fields.setWidget(2, 0, untertitelLabel);
			fields.setWidget(2, 1, untertitel);
			fields.setWidget(3, 0, inhaltLabel);
			fields.setWidget(3, 1, inhalt);
			
			fields.setWidget(4, 0, saveBtn);
			
			mainPanel.add(fields);
					
			// Wrapper, wrapps any HTML element with an id of "BlogeintragContainer"
			
			RootPanel.get("Container").add(mainPanel);
			saveBtn.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					Window.alert(title.getText() + "\n" + untertitel.getText() + "\n" + inhalt.getText());
					addBlogeintrag();
				}		
			});
		}
			
			public void addBlogeintrag(){
				
				taskControll.createBlogeintrag(inhalt.getText(), title.getText(), untertitel.getText(), new AsyncCallback<Blogeintrag>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Fehler aufgetreten.");
						
					}

					@Override
					public void onSuccess(Blogeintrag result) {
						if( result != null) {
							updateCounter();				
						}
					}
					
				});
				
			}
		

		public void updateCounter() {
			
			taskControll.findAll(new AsyncCallback<Vector<Blogeintrag>>(){
				
				public void onFailure(Throwable caught) {
					Window.alert(SERVER_ERROR);
				}
				
				public void onSuccess(Vector<Blogeintrag> be) {
					if(be!=null) {
						counter = be.size() + 1;
					}
				}
			});
			
	
		}
		
}
