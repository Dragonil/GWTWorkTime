
public class AufgabenAdministration {

	Aufgabe findByKey(int id);
	
	Vector<Aufgabe> findAll();
	
	Vector<User> findByTitel(String titel);
	
	Aufgabe insert(Aufgabe a);
	
	Aufgabe update(Aufgabe a);
	
	void delete(Aufgabe a);
	
	Notiz findByKey(int id);
	
	Vector<Notiz> findAll();
	
	Vector<Notiz> findByDate(Date datum);
	
	Vector<Notiz> findByTask(Aufgabe a);
	
	Notiz insert(Notiz c);
	
	Notiz update(Notiz c);
	
	void delete(Notiz c);
	
	User findByKey(int id);
	
	Vector<User> findAll();
	
	Vector<User> findByLastName(String name);
	
	User insert(User u);
	
	User update(User u);
	
	void delete(User u);
	
}
