package main.java;

import java.util.Scanner;

import main.java.beans.Account;
import main.java.beans.Customer;
import main.java.transverse.UtilClass;

public class Main {

	public static void main(String[] args) {

		Customer c1 = new Customer("Mohand", "HASSOUNA", "25 rue de Cuques");
		Account a1 =  c1.createAccount(c1.getCustomerId());
		//c1.createAccount(c1.getCustomerId());
		
		boolean quit = false;
		System.out.println("==============================================================");
		System.out.println("Welcome dear "+ c1.getFirstName() +", what do you want from your bank today ?");
		System.out.println("==============================================================");
		/** case : the customer has just one account **/
		if(c1.getIdAccounts().size() == 1)
		{
		
		System.out.println("A : Check the balance \nB : Make a withdrawal \nC : Make a deposit \nD : Check the personal information \nE : Quit ");
		
		do
		{
		Scanner sc = new Scanner(System.in);
		char choice = sc.next().charAt(0);
		
		switch (choice) {
		case 'A':
			System.out.print("Balance : "+a1.getBalance());
			break;
		case 'B':

			break;
		case 'C':
			System.out.print("Balance : "+a1.getBalance());
			break;
		case 'D':
			System.out.println(c1.toString());
			break;
		case 'E':
			System.out.println("Thank you for your visit, see you soon :)");
			quit = true;
			break;
		default:
			
			break;
		}
		}
		while(!quit);
		}
		/** case : the customer has more than one account **/
		else
		{
			
		}
	}

}
