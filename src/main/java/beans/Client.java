package main.java.beans;

import java.util.List;

public class Client {

	 private String firstName;
	 private String lastName;
	 private String address;
	 private List <Integer> idAccounts;
	
	 
	 
	 public Client(String firstName, String lastName, String address)
	 {
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.address = address;
	 }
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Integer> getIdAccounts() {
		return idAccounts;
	}
	public void setIdAccounts(List<Integer> idAccounts) {
		this.idAccounts =  idAccounts;
	}
	
	public Account createAccount(int idAccount)
	{
		Account account = new Account(idAccount);
		account.createAccount();
		return account;
	}
	
}
