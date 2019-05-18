package main.java.beans;

import java.util.Calendar;

import main.java.transverse.UtilClass;
import main.java.transverse.UtilClass.operationType;

public class Operation {
	
	/** The type of the operation **/
	private String type;
	/** The balance after the operation is made **/
	private double balance;
	/** The date of the operation **/
	private String date;
	/** The amount of the operation **/
	private double amount ;
	/** The operation's account id**/
	private Long accountId;
	
	
	public Operation(double balance, Calendar date, double amount, Long accountId, operationType operationType )
	{
		this.amount= amount;
		this.accountId = accountId;
		this.date = UtilClass.getStringFromCalendar(date);
		this.balance = balance;
		this.type = operationType.name().toString();
		
	}
	
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Operation [type=" + type + ", balance=" + balance + ", date=" + date + ", amount=" + amount
				+ ", idAccount=" + accountId + "]";
	}

}
