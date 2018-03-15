
public class CreateNotiz {
	
public static void main(String[] args) {
		
		AufgabenAdministration adm = new AufgabenAdministration();	
		adm.createBlogeintrag("Das ist der Inhalt des Blogeintrags", "Titel", "Untertitel");		
		
		ShowAll.main(new String[0]);

	}

}
