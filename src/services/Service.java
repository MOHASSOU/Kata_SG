package services;

import main.java.beans.Account;
import main.java.beans.Customer;

public class Service {

	
	public Account getAccount(Long idAccount)
	{
		/** Call the sub layers to retrieve data **/
		return null;
	}
	
	public Customer getClient(int idClient)
	{
		/** Call the sub layers to retrieve data **/
		return null;
	}
	public Customer createClient(String firstName, String lastName, String address)
	{
		return new Customer(firstName, lastName, address);
		
	}
	
	public Account createAccount(Long idClient)
	{
		return  new Account(idClient);
	}
}
