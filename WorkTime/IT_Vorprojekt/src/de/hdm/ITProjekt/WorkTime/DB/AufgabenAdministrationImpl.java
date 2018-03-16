package de.hdm.ITProjekt.WorkTime.DB;

import java.util.ArrayList;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.ITProjekt.WorkTime.shared.bo.Aufgabe;
import de.hdm.ITProjekt.WorkTime.shared.bo.User;
import package de.hdm.ITProjekt.WorkTime.DB.AufgabeMapper;

public class AufgabenAdministrationImpl extends RemoteServiceServlet
implements AufgabenAdministration {
	
	 public static final int DEFAULT_CASH_ACCOUNT_ID = 10000;

	  private User user = null;

	  private AufgabeMapper aMapper = null;
	  private NotizMapper nMapper = null;
	 
	  
	  public AufgabenAdministrationImpl() throws IllegalArgumentException {
	   
	  }

	  @Override
	  public void init() throws IllegalArgumentException {
	  
	    this.aMapper = AufgabeMapper.aufgabeMapper();
	    this.nMapper = NotizMapper.notizMapper();
	    
	  
	 }

	  @Override
	  public User createUser(String vorname, String nachname) throws IllegalArgumentException {
	    User u = new User();
	    u.setFirstName(vorname);
	    u.setLastName(nachname);

	    c.setId(1);

	    return this.uMapper.insert(c);
	  }

	  /**
	   * Auslesen aller Kunden, die den übergebenen Nachnamen besitzen.
	   */
	  @Override
	public Vector<Customer> getCustomerByName(String lastName)
	      throws IllegalArgumentException {

	    return this.cMapper.findByLastName(lastName);
	  }

	  /**
	   * Auslesen eines Kunden anhand seiner Kundennummer.
	   */
	  @Override
	public Customer getCustomerById(int id) throws IllegalArgumentException {
	    return this.cMapper.findByKey(id);
	  }

	  /**
	   * Auslesen aller Kunden.
	   */
	  @Override
	public Vector<Customer> getAllCustomers() throws IllegalArgumentException {
	    return this.cMapper.findAll();
	  }

	  /**
	   * Speichern eines Kunden.
	   */
	  @Override
	public void save(Customer c) throws IllegalArgumentException {
	    cMapper.update(c);
	  }

	  /**
	   * Löschen eines Kunden. Natürlich würde ein reales System zur Verwaltung von
	   * Bankkunden ein Löschen allein schon aus Gründen der Dokumentation nicht
	   * bieten, sondern deren Status z.B von "aktiv" in "ehemalig" ändern. Wir
	   * wollen hier aber dennoch zu Demonstrationszwecken eine Löschfunktion
	   * vorstellen.
	   */
	  @Override
	public void delete(Customer c) throws IllegalArgumentException {
	    /*
	     * Zunächst werden sämtl. Konten des Kunden aus der DB entfernt.
	     * 
	     * Beachten Sie, dass wir dies auf Ebene der Applikationslogik, konkret: in
	     * der Klasse BankVerwaltungImpl, durchführen. Grund: In der Klasse
	     * BankVerwaltungImpl ist die Verflechtung sämtlicher Klassen bzw. ihrer
	     * Objekte bekannt. Nur hier kann sinnvoll ein umfassender Verwaltungsakt
	     * wie z.B. dieser Löschvorgang realisiert werden.
	     * 
	     * Natürlich könnte man argumentieren, dass dies auch auf Datenbankebene
	     * (sprich: mit SQL) effizienter möglich ist. Das Gegenargument ist jedoch
	     * eine dramatische Verschlechterung der Wartbarkeit Ihres Gesamtsystems
	     * durch einen zu niedrigen Abstraktionsgrad und der Verortung von Aufgaben
	     * an einer Stelle (Datenbankschicht), die die zuvor genannte Verflechtung
	     * nicht umfänglich kennen kann.
	     */
	    Vector<Account> accounts = this.getAccountsOf(c);

	    if (accounts != null) {
	      for (Account a : accounts) {
	        this.delete(a);
	      }
	    }

	    // Anschließend den Kunden entfernen
	    this.cMapper.delete(c);
	  }

	  /*
	   * ***************************************************************************
	   * ABSCHNITT, Ende: Methoden für Customer-Objekte
	   * ***************************************************************************
	   */

	  /*
	   * ***************************************************************************
	   * ABSCHNITT, Beginn: Methoden für Account-Objekte
	   * ***************************************************************************
	   */
	  /**
	   * Auslesen sämtlicher Konten dieses Systems.
	   */
	  @Override
	public Vector<Account> getAllAccounts() throws IllegalArgumentException {
	    return this.aMapper.findAll();
	  }

	  /**
	   * Auslesen aller Konten des übergeben Kunden.
	   */
	  @Override
	public Vector<Account> getAccountsOf(Customer c)
	      throws IllegalArgumentException {
	    return this.aMapper.findByOwner(c);
	  }
	  
	  /**
	   * Auslesen des Kontos mit einer bestimmten Id
	   */
	  @Override
	public Account getAccountById(int id) throws IllegalArgumentException {
		  return aMapper.findByKey(id);
	  }

	  /**
	   * Löschen des übergebenen Kontos. Beachten Sie bitte auch die Anmerkungen zu
	   * {@link #delete(Customer)}. Beim Löschen des Kontos werden sämtliche damit
	   * in Verbindung stehenden Buchungen gelöscht.
	   * 
	   * @see #delete(Customer)
	   */
	  @Override
	public void delete(Account a) throws IllegalArgumentException {
	    /*
	     * Zunächst werden sämtl. Buchungen des Kunden aus der DB entfernt.
	     */
	    ArrayList<Transaction> debits = this.getDebitsOf(a);
	    ArrayList<Transaction> credits = this.getCreditsOf(a);

	    if (debits != null) {
	      for (Transaction t : debits) {
	        this.delete(t);
	      }
	    }

	    if (credits != null) {
	      for (Transaction t : credits) {
	        this.delete(t);
	      }
	    }

	    // Account aus der DB entfernen
	    this.aMapper.delete(a);
	  }

	  /**
	   * Anlegen eines neuen Kontos für den übergebenen Kunden. Dies führt implizit
	   * zu einem Speichern des neuen, leeren Kontos in der Datenbank.
	   * <p>
	   * 
	   * <b>HINWEIS:</b> Änderungen an Account-Objekten müssen stets durch Aufruf
	   * von {@link #save(Account)} in die Datenbank transferiert werden.
	   * 
	   * @see save(Account a)
	   */
	  @Override
	public Account createAccountFor(Customer c) throws IllegalArgumentException {
	    Account a = new Account();
	    a.setOwnerID(c.getId());

	    /*
	     * Setzen einer vorläufigen Kontonr. Der insert-Aufruf liefert dann ein
	     * Objekt, dessen Nummer mit der Datenbank konsistent ist.
	     */
	    a.setId(1);

	    // Objekt in der DB speichern.
	    return this.aMapper.insert(a);
	  }

	  /**
	   * <p>
	   * Ausgeben des Kontostands des übergebenen Kontos. Dieser wird durch ein
	   * gegeneinander Aufrechnen von Zubuchungen und Abbuchungen auf Basis von
	   * {@link Transaction}-Instanzen bestimmt.
	   * </p>
	   * 
	   * @param k das Konto, dessen Stand wir berechnen möchten
	   */
	  @Override
	public float getBalanceOf(Account k) throws IllegalArgumentException {
	    float creditAmount = 0.0f;
	    float debitAmount = 0.0f;

	    ArrayList<Transaction> credits = this.getCreditsOf(k);
	    ArrayList<Transaction> debits = this.getDebitsOf(k);

	    if (credits != null) {
	      for (Transaction b : credits) {
	        creditAmount += b.getAmount();
	      }
	    }

	    if (debits != null) {
	      for (Transaction b : debits) {
	        debitAmount += b.getAmount();
	      }
	    }

	    return creditAmount - debitAmount;
	  }

	  /**
	   * <p>
	   * Auslesen sämtlicher mit diesem Konto in Verbindung stehenden
	   * Soll-Buchungen. Diese Methode wird in {@link #getBalanceOf(Account)}
	   * verwendet.
	   * </p>
	   * 
	   * @param k das Konto, dessen Soll-Buchungen wir bekommen wollen.
	   * @return eine Liste aller Soll-Buchungen
	   * @throws IllegalArgumentException
	   */
	  @Override
	public ArrayList<Transaction> getDebitsOf(Account k)
	      throws IllegalArgumentException {
	    ArrayList<Transaction> result = new ArrayList<Transaction>();

	    if (k != null && this.tMapper != null) {
	      Vector<Transaction> transactions = this.tMapper.findBySourceAccount(k
	          .getId());
	      if (transactions != null) {
	        result.addAll(transactions);
	      }
	    }

	    return result;
	  }

	  /**
	   * <p>
	   * Auslesen sämtlicher mit diesem Konto in Verbindung stehenden
	   * Haben-Buchungen. Diese Methode wird in {@link #getBalanceOf(Account)}
	   * verwendet.
	   * </p>
	   * 
	   * @param k das Konto, dessen Haben-Buchungen wir bekommen wollen.
	   * @return eine Liste aller Haben-Buchungen
	   * @throws IllegalArgumentException
	   */
	  @Override
	public ArrayList<Transaction> getCreditsOf(Account k)
	      throws IllegalArgumentException {
	    ArrayList<Transaction> result = new ArrayList<Transaction>();

	    if (k != null && this.tMapper != null) {
	      Vector<Transaction> transactions = this.tMapper.findByTargetAccount(k
	          .getId());
	      if (transactions != null) {
	        result.addAll(transactions);
	      }
	    }

	    return result;
	  }

	  /**
	   * Speichern eines Kontos.
	   */
	  @Override
	public void save(Account a) throws IllegalArgumentException {
	    aMapper.update(a);
	  }

	  /*
	   * ***************************************************************************
	   * ABSCHNITT, Ende: Methoden für Account-Objekte
	   * ***************************************************************************
	   */

	  /*
	   * ***************************************************************************
	   * ABSCHNITT, Beginn: Methoden für Transaction-Objekte
	   * ***************************************************************************
	   */
	  /**
	   * Erstellen einer neuen Buchung.
	   * 
	   * @param source das Quellkonto
	   * @param target das Zielkonto
	   * @param value der Geldwert dieser Buchung
	   */
	  @Override
	public Transaction createTransactionFor(Account source, Account target,
	      float value) throws IllegalArgumentException {

	    /*
	     * Wir legen eine neue, leere Buchung an.
	     */
	    Transaction t = new Transaction();

	    /*
	     * Setzen einer vorläufigen Kontonr. Der insert-Aufruf liefert dann ein
	     * Objekt, dessen Nummer mit der Datenbank konsistent ist.
	     */
	    t.setId(1);

	    /*
	     * Setzen des Quell- und des Zielkontos.
	     */
	    t.setSourceAccountID(source.getId());
	    t.setTargetAccountID(target.getId());

	    /*
	     * Setzen des Geldwerts, der von Quellkonto zum Zielkontos z.B als Folge
	     * einer Überweisung gebucht werden soll.
	     */
	    t.setAmount(value);

	    // Objekt in der DB speichern.
	    return this.tMapper.insert(t);
	  }

	  /**
	   * Löschen der übergebenen Buchung. Beachten Sie bitte auch die Anmerkungen zu
	   * {@link #delete(Customer)} und {@link #delete(Account)}.
	   * 
	   * @see #delete(Customer)
	   * @see #delete(Account)
	   */
	  @Override
	public void delete(Transaction t) throws IllegalArgumentException {
	    this.tMapper.delete(t);
	  }

	  /**
	   * Auslesen des Kassenkontos der Bank.
	   * 
	   * @return das Kassenkonto der Bank
	   */
	  private Account getCashAccount() {
	    Account account = aMapper.findByKey(DEFAULT_CASH_ACCOUNT_ID);
	    /* wenn das Kassenkonto nicht gefunden wird, erzeugen wir es mit der entsprechenden
	     * Kontonummer und dem Wert 0 als ownerID.
	     */
	    if (account == null) {
	    	account = new Account();
	    	account.setId(DEFAULT_CASH_ACCOUNT_ID);
	    	account.setOwnerID(0);
	    	save(account);
	    	}
	    return account;
	  }

	  /**
	   * Hier wird der Use Case abgebildet, dass der Kunde eine <b>Barabhebung</b>
	   * von einem Konto machen möchte. Es wird hierdurch ein Buchungssatz
	   * 
	   * <pre>
	   * Kundenkonto <Betrag>
	   * an Kasse <Betrag>
	   * </pre>
	   * 
	   * realisiert.
	   * 
	   * @param customerAccount das Kundenkonto, von dem die Barabhebung erfolgen
	   *          soll.
	   * @param amount der Betrag, der abgehoben werden soll.
	   * @return Ein <code>Transaction</code>-Objekt, das den resultierenden
	   *         Buchungssatz darstellt.
	   */
	  @Override
	public Transaction createWithdrawal(Account customerAccount, float amount) {
	    Account cashAccount = this.getCashAccount();
	    if (cashAccount != null) {
	      Transaction trans = this.createTransactionFor(customerAccount,
	          cashAccount, amount);
	      return trans;
	    }
	    else {
	      return null;
	    }
	  }

	  /**
	   * Hier wird der Use Case abgebildet, dass der Kunde eine <b>Bareinzahlung</b>
	   * auf einem Konto machen möchte. Es wird hierdurch ein Buchungssatz
	   * 
	   * <pre>
	   * Kasse <Betrag>
	   * an Kundenkonto <Betrag>
	   * </pre>
	   * 
	   * realisiert.
	   * 
	   * @param customerAccount das Kundenkonto, auf das der Betrag eingezahlt
	   *          werden soll.
	   * @param amount der Betrag, der eingezahlt wird.
	   * @return Ein <code>Transaction</code>-Objekt, das den resultierenden
	   *         Buchungssatz darstellt.
	   */
	  @Override
	public Transaction createDeposit(Account customerAccount, float amount) {
	    Account cashAccount = this.getCashAccount();
	    if (cashAccount != null) {
	      Transaction trans = this.createTransactionFor(cashAccount,
	          customerAccount, amount);
	      return trans;
	    }
	    else {
	      return null;
	    }
	  }

	  /*
	   * ***************************************************************************
	   * ABSCHNITT, Ende: Methoden für Transaction-Objekte
	   * ***************************************************************************
	   */

	  /*
	   * ***************************************************************************
	   * ABSCHNITT, Beginn: Verschiedenes
	   * ***************************************************************************
	   */
	  /**
	   * Auslesen der Bank für die diese Bankverwaltung gewissermaßen tätig ist.
	   */
	  @Override
	public Bank getBank() throws IllegalArgumentException {
	    return this.bank;
	  }

	  /**
	   * Setzen der Bank für die diese Bankverwaltung tätig ist.
	   */
	  @Override
	public void setBank(Bank b) throws IllegalArgumentException {
	    this.bank = b;
	  }
	  /*
	   * ***************************************************************************
	   * ABSCHNITT, Ende: Verschiedenes
	   * ***************************************************************************
	   */

	}
