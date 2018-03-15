import com.google.gwt.user.client.rpc.AsyncCallback;

public class AufgabenAdministrationAsync {

	void findByKey(int id, AsyncCallback <Aufgabe> callback);
	
	void findAll(AsyncCallback <Vector<Aufgabe>> callback);
	
	void findByTitel(String titel, AsyncCallback <Vector<User>> callback);
	
	void insert(Aufgabe a, AsyncCallback <Aufgabe> callback);
	
	void update(Aufgabe a, AsyncCallback <Aufgabe> callback);
	
	void delete(Aufgabe a, AsyncCallback <Void> callback);
	
	void findByKey(int id, AsyncCallback <Notiz> callback);
	
	void findAll(AsyncCallback <Vector<Notiz>> callback);
	
	void findByDate(Date datum, AsyncCallback <Vector<Notiz>> callback);
	
	void findByTask(Aufgabe a, AsyncCallback <Vector<Notiz>> callback);
	
	void insert(Notiz c, AsyncCallback <Notiz> callback);
	
	void update(Notiz c, AsyncCallback <Notiz> callback);
	
	void delete(Notiz c, AsyncCallback <Void> callback);
	
	void findByKey(int id, AsyncCallback <User> callback);
	
	void findAll(AsyncCallback <Vector<User>> callback);
	
	void findByLastName(String name, AsyncCallback <Vector<User>> callback);
	
	void insert(User u, AsyncCallback <User> callback);
	
	void update(User u, AsyncCallback <User> callback);
	
	void delete(User u, AsyncCallback <Void> callback);
	
	
}
