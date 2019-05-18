package main.java;

import java.util.Scanner;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;

import main.java.beans.Account;
import main.java.beans.Customer;
import main.java.transverse.UtilClass;

public class Main {

	public static void main(String[] args) {

		Customer c1 = new Customer("Mohand", "HASSOUNA", "25 rue de Cuques");
		Account a1 =  c1.createAccount(c1.getCustomerId(), 300f);
		//c1.createAccount(c1.getCustomerId());
		
		System.out.println("==============================================================");
		System.out.println("Welcome dear "+ c1.getFirstName() +", what do you want from your bank today ?");
		System.out.println("==============================================================");
		/** case : the customer has just one account **/
		if(c1.getIdAccounts().size() == 1)
		{
		
		System.out.println("A : Check the balance \nB : Make a withdrawal \nC : Make a deposit \nD : Check the personal information \nE : Display the operations history \nF : Quit");
		char choice;
		Scanner sc = new Scanner(System.in);
		do
		{
		choice = sc.next().charAt(0);
		
		switch (choice) {
		case 'A':
			System.out.print("Balance : "+a1.getBalance());
			break;
		case 'B':
			System.out.println("Enter an amount to withdraw : ");
			Scanner sc1 = new Scanner(System.in);
			double withdAmount = sc1.nextDouble();
			System.out.println(a1.makeWithdrawal(withdAmount));

			break;
		case 'C':
			System.out.println("Enter an amount to deposit : ");
			Scanner sc2 = new Scanner(System.in);
			double depositAmount = sc2.nextDouble();
			System.out.println(a1.makeADeposit(depositAmount));
			break;
		case 'D':
			System.out.println(c1.toString());
			break;
		case 'E':
			a1.getOperationList().forEach(i->System.out.println(i.toString()));
			break;
		case 'F':
			System.out.println("Thank you for your visit, see you soon :)");
			break;
		default:
			System.out.println("Invalid choice, please retry again.");
			break;
		}
		}
		while(choice != 'F');
		}
		
		
		/** case : the customer has more than one account **/
		else
		{
			/** To develop **/
		}
	}

}
