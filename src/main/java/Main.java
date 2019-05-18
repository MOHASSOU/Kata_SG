package main.java;

import main.java.beans.Account;
import main.java.beans.Customer;
import main.java.transverse.UtilClass;

public class Main {

	public static void main(String[] args) {

		Customer c1 = new Customer("Mohand", "HASSOUNA", "25 rue de Cuques");
		c1.createAccount(c1.getCustomerId());
		c1.createAccount(c1.getCustomerId());
		
		System.out.println(c1.toString());
		
	}

}
