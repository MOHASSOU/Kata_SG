package main.java.beans;

import main.java.transverse.Constants;
import main.java.transverse.UtilClass;

public class Account {

	
	private int idAccount;
	private volatile float balance;
	private int idClient;
	
	
	public Account(int idAccount)
	{
		this.idAccount = idAccount;
	}
	
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	public String makeWithdrawal(float amount)
	{
		if(this.balance < amount)
			return Constants.INSUFFICIENT_BLANCE;
		else
		{
			this.balance -= amount;
			new Operation (balance, UtilClass.getCurrentDate(), amount, idAccount);
			return Constants.SUCCESSFUL_WITHDRAWAL;
			
		}
		
	}
	
	public void makeADeposit(float amount)
	{
		
	}
	
	public void createAccount()
	{
		
	}
	
}
