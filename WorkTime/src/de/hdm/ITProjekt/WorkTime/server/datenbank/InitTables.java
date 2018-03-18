package de.hdm.ITProjekt.WorkTime.server.datenbank;

public class InitTables {
	
	public static void main(String[] args) {

		UserMapper.removeTable();
		AufgabeMapper.removeTable();
		NotizMapper.removeTable();
		
		UserMapper.createTable();
		AufgabeMapper.createTable();
		NotizMapper.createTable();
		

	}


}
