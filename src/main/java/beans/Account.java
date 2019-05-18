package main.java.beans;

import java.util.concurrent.atomic.AtomicLong;

import main.java.transverse.Constants;
import main.java.transverse.UtilClass;

public class Account {

	/** To generate a unique id for each account **/
	private static AtomicLong nextId = new AtomicLong(1);
	private final Long idAccount;
	
	/** Banking account data information **/
	private volatile float balance;
	private Long customerId;
	private float previousBalance;
	
	
	public Account(Long customerId)
	{
		this.idAccount = nextId.getAndIncrement();
		this.customerId = customerId;
		this.balance = 0;
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
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public float getPreviousBalance() {
		return previousBalance;
	}
	public void setPreviousBalance(float previousBalance) {
		this.previousBalance = previousBalance;
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
		this.previousBalance = balance;
		this.balance += amount;
		
	}
	
	
}
