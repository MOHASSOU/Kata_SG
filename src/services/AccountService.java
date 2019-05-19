package services;

import main.java.beans.Account;
import main.java.beans.Customer;
import main.java.beans.Operation;
import main.java.transverse.Constants;
import main.java.transverse.UtilClass;

public class AccountService {

	
	public Account getAccountById(Long accountId)
	{
		/** Call the sub layers to retrieve data **/
		return null;
	}
	
	
	
	public Account createAccount(Customer customer, double overdraft)
	{
		Account account = new Account(customer.getCustomerId(), overdraft);
		customer.getIdAccounts().add(account.getIdAccount());
		return account;
		
	}
	
	public String makeADeposit(Account account, double amount)
	{
		/** Make sure to not deposit the negative or zero amount value **/
		if(amount<=0)
		{
			return Constants.INVALID_AMOUNT;
		}
		account.setBalance(account.getBalance() + amount);
		account.getOperationList().add(new Operation (account.getBalance(), UtilClass.getCurrentDate(), amount, account.getIdAccount(), UtilClass.operationType.DEPOSIT));
		return Constants.SUCCESSFUL_DEPOSIT;
	}
	
	public String makeWithdrawal(Account account, double amount)
	{
		/** Make sure to not withdrawal the negative or zero amount value **/
		if(amount<=0)
		{
			return Constants.INVALID_AMOUNT;
		}
		if((account.getOverdraft() + account.getBalance()) < amount)
			return Constants.INSUFFICIENT_BLANCE;
		else
		{
			account.setBalance(account.getBalance() - amount); 	
			account.getOperationList().add(new Operation (account.getBalance(), UtilClass.getCurrentDate(), amount, account.getIdAccount(), UtilClass.operationType.WITHDRAWAL));
			return Constants.SUCCESSFUL_WITHDRAWAL;
			
		}
		
	}
}
