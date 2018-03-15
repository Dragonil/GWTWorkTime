package de.hdm.ITProjekt.WorkTime.shared.bo;

public class User extends BusinessObject {

	private static final long serialVersionUID = 1L;
	
	private String firstName = "";

	private String lastName = "";

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}