package services;

import main.java.beans.Account;
import main.java.beans.Client;

public class Service {

	
	public Account getAccount(int idAccount)
	{
		/** Call the sub layers to retrieve data **/
		return null;
	}
	
	public Client getClient(int idClient)
	{
		/** Call the sub layers to retrieve data **/
		return null;
	}
	public Client createClient(String firstName, String lastName, String address)
	{
		return new Client(firstName, lastName, address);
		
	}
	
	public Account createAccount(int idClient)
	{
		return  new Account(idClient);
	}
}
