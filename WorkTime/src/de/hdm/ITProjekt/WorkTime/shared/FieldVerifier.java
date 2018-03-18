package de.hdm.ITProjekt.WorkTime.shared;

public class FieldVerifier {

	public static boolean isValidPassword(String pw) {
		if (pw == null) {
			return false;
		}
		return pw.length() > 3;
	}
	
	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		return name.length() > 3;
	}
	
}