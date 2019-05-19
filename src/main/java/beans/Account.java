package main.java.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Account {

	/** To generate a unique id for each account **/
	private static AtomicLong nextId = new AtomicLong(1);
	private final Long idAccount;
	
	/** Banking account data information **/
	private volatile double balance;
	private Long customerId;
	private double overdraft;
	
	/** One to many Account -> Operation **/
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
	
}
