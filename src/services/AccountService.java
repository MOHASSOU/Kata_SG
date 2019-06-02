package services;

import java.util.ArrayList;
import java.util.List;
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
	
	
	
	public Account createAccount(Customer customer, double overdraft, double initialBalance)
	{
		Account account = new Account(customer.getCustomerId(), overdraft, initialBalance);
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
	
	public List<String> getAccountsLastOperations(Account account) throws Exception
	{
		if(account == null || account.getIdAccount() == null )
		{
			throw new Exception(Constants.INVALID_ACCOUNT);
		}
		if( account.getCustomerId() == null)
		{
			throw new Exception(Constants.INVALID_CUSTOMER);

		}
		List <String> operationList = new ArrayList<String>();
		
		account.getOperationList().forEach(i-> operationList.add(i.toString()));
		
		return operationList;
	}
}
