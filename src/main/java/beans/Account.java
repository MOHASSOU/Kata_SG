package main.java.beans;

import java.util.concurrent.atomic.AtomicLong;

import main.java.transverse.Constants;
import main.java.transverse.UtilClass;

public class Account {

	/** To generate a unique id for each account **/
	private static AtomicLong nextId = new AtomicLong(1);
	private final Long idAccount;
	
	/** Banking account data information **/
	private volatile double balance;
	private Long customerId;
	private double overdraft;

	public Account(Long customerId, double overdraft)
	{
		this.idAccount = nextId.getAndIncrement();
		this.customerId = customerId;
		this.balance = 0;
		this.overdraft = overdraft;
	}
	
	
	public Long getIdAccount() {
		return idAccount;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	
	
	
	
	public String makeWithdrawal(double amount)
	{
		if(amount<=0)
		{
			return Constants.INVALID_AMOUNT;
		}
		if((overdraft + balance) < amount)
			return Constants.INSUFFICIENT_BLANCE;
		else
		{
			this.balance -= amount;
			new Operation (balance, UtilClass.getCurrentDate(), amount, idAccount);
			return Constants.SUCCESSFUL_WITHDRAWAL;
			
		}
		
	}
	
	public String makeADeposit(double amount)
	{
		if(amount<=0)
		{
			return Constants.INVALID_AMOUNT;
		}
		this.balance += amount;
		return Constants.SUCCESSFUL_DEPOSIT;
	}
	
	
}
