package main.java.beans;

import java.util.ArrayList;
import java.util.List;
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
	
	/** One to many Account -> Operation**/
	private List<Operation> operationList;

	
	public Account(Long customerId, double overdraft)
	{
		this.idAccount = nextId.getAndIncrement();
		this.customerId = customerId;
		this.balance = 0;
		this.overdraft = overdraft;
		this.operationList = new ArrayList<>();
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
	public List<Operation> getOperationList() {
		return operationList;
	}
	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}


	
	
	
	public String makeWithdrawal(double amount)
	{
		/** Make sure to not withdrawal the negative or zero amount value **/
		if(amount<=0)
		{
			return Constants.INVALID_AMOUNT;
		}
		if((overdraft + balance) < amount)
			return Constants.INSUFFICIENT_BLANCE;
		else
		{
			this.balance -= amount;	
			this.operationList.add(new Operation (balance, UtilClass.getCurrentDate(), amount, idAccount, UtilClass.operationType.WITHDRAWAL));
			return Constants.SUCCESSFUL_WITHDRAWAL;
			
		}
		
	}
	
	public String makeADeposit(double amount)
	{
		/** Make sure to not deposit the negative or zero amount value **/
		if(amount<=0)
		{
			return Constants.INVALID_AMOUNT;
		}
		this.balance += amount;
		new Operation (balance, UtilClass.getCurrentDate(), amount, idAccount, UtilClass.operationType.DEPOSIT);
		this.operationList.add(new Operation (balance, UtilClass.getCurrentDate(), amount, idAccount, UtilClass.operationType.DEPOSIT));
		return Constants.SUCCESSFUL_DEPOSIT;
	}
	
	
}
