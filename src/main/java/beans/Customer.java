package main.java.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Customer {
	
	 @Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", idAccounts=" + idAccounts + "]";
	}

	/** To generate a unique id for each customer **/
	 private static AtomicLong nextId = new AtomicLong(1);
	 private final Long customerId; 
	
	 /** Customer's personal information **/
	 private String firstName;
	 private String lastName;
	 private String address;
	 
	 /** An array that stocking the id of each account of the customer **/
	 private List <Long> idAccounts;
	
	 
	 
	 public Customer(String firstName, String lastName, String address)
	 {
		 this.customerId = nextId.getAndIncrement();
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.address = address;
		 this.idAccounts = new ArrayList<>();
	 }
	
	 	public Long getCustomerId() {
			return customerId;
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
	public List<Long> getIdAccounts() {
		return idAccounts;
	}
	public void setIdAccounts(List<Long> idAccounts) {
		this.idAccounts =  idAccounts;
	}
	
	public Account createAccount(Long customerId, double overdraft)
	{
		Account account = new Account(customerId, overdraft);
		this.idAccounts.add(account.getIdAccount());
		return account;
	}
	
}
