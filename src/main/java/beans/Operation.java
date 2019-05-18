package main.java.beans;

import java.util.Calendar;

public class Operation {
	
	
	private int operation;
	private float balance;
	private Calendar date;
	private float amount ;
	private Long idAccount;
	
	
	public Operation(float balance, Calendar date, float amount, Long idAccount )
	{
		this.amount= amount;
		this.idAccount = idAccount;
		this.date = date;
		this.balance = balance;
	}
	
	public Long getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

}
