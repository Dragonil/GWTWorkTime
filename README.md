# GWTWorkTime
IT Vorprojekt

Aufgabe:
  Erstelle ein Zeit/Aufgabenmanagment tool mit GWT/Java 
  
Java Klassen:
  + User 
  + Aufgabe
  + Notiz
  + Kanban
  + Statistik
  + Login/Registrierung
  + dazugehörige DB Mapper
  
  


  Gruppe 1: Katalin(Notiz, Statistik), Marco (User, Login), Burak(Aufgabe, Kanban) </br>
  Gruppe 2: Kimly, Janina
  
  
  
  Aufgaben Gruppe1
  
  
  Falls die Loginseite nicht funtioniert, in client/Worktime die Variable activeModule auf 2 setzen


Marco:
In der Klasse server/ComImpl alle Methoden füllen, bsp. Alle anderen Methoden

Die Klasse client/Benutzer das VertiaclPanel mit Inhalt füllen, z.B. alle Nutzerdaten anzeigen 

Eventuell, Logout Button der den Nutzer wieder zum Modul 1 bringt, ( Änderung des activeModule & update der Ansicht in client/WorkTime ) 



Burak:
Füllen des KabanBoard mit aufgaben aus der Datenbank, Beispiele und Erklärungen als Kommentar in der Klasse client/Kanban

Wenn die Aufgaben erledigt ist in der Klasse client/DragPanel ein Kommentar in der Methode iniDrop entfernen 

Eventuell, die Klasse nAufgabe umschreiben/verschönern, da die Tabelle dort nichtmehr benötigt wird.



Katalin:
In der Klasse client/Statistik die Tabellen mit Aufgabendaten füllen und einen Weitere Tabelle erstellen, wo alle Nutzer angezeigt werden aufgelistet werden.

In der Klasse client/WorkTime den Aktualisieren Butten für das Statistik panel implementieren, Beschreibung und bsp in der Klasse client/WorkTime

  
