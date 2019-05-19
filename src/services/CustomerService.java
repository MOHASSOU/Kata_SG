package services;

import main.java.beans.Account;
import main.java.beans.Customer;
import main.java.beans.Operation;
import main.java.transverse.Constants;
import main.java.transverse.UtilClass;

public class CustomerService {

	
	
	public Customer getCustomerById(int customerId)
	{
		/** Call the sub layers to retrieve data **/
		return null;
	}
	
	
	
	public Customer createCustomer(String firstName, String lastName, String address) throws Exception
	{
		if(firstName == null || lastName == null || address == null)
		{
			throw new Exception(Constants.NULL_OR_INVALID_INFORMATION);		
		}
		return new Customer(firstName, lastName, address);	
	}
	
}
