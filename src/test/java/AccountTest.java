package test.java;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import org.junit.Assert; 
import main.java.beans.Account;
import main.java.transverse.Constants;
import services.AccountService;

public class AccountTest {

	ApplicationContext appContext = new FileSystemXmlApplicationContext("src/main/resources/app-context.xml");
	AccountService accountMockedService = appContext.getBean("accountService", AccountService.class);
	AccountService accountService = appContext.getBean("accountService", AccountService.class);
	
	 private Account accountTest;
	 
	@org.junit.Before
	public void initTest() 
	{
	    accountMockedService = Mockito.mock(AccountService.class);
	    accountTest = new Account(1L, 300f, 0f);
		Mockito.when(accountMockedService.getAccountById(Mockito.anyLong())).thenReturn(accountTest);
	}
	 
	
	/** ###################################################################### **/
	/** Test cases to build the Withdrawal Functionality **/
	/** ###################################################################### **/
	
	@Test
	public void makeWithdrawalBalaceExcessFailure()
	{
	   accountTest.setBalance(500f);
	   Mockito.when(accountMockedService.getAccountById(Mockito.anyLong())).thenReturn(accountTest);
	   Assert.assertEquals (accountService.makeWithdrawal(accountMockedService.getAccountById(22L), 801f), Constants.INSUFFICIENT_BLANCE);
		
	}
	
	@Test
	public void makeWithdrawalNegativeAmount()
	{		 
	   Assert.assertEquals (accountService.makeWithdrawal(accountMockedService.getAccountById(22L), -1f), Constants.INVALID_AMOUNT);			
	}
	
	@Test
	public void makeWithdrawalZeroAmount()
	{
	 	 
	   Assert.assertEquals (accountService.makeWithdrawal(accountMockedService.getAccountById(22L), 0f), Constants.INVALID_AMOUNT);	
	}
	
	@Test
	public void makeWithdrawalSuccess()
	{
	   accountTest.setBalance(500f);
	   Mockito.when(accountMockedService.getAccountById(Mockito.anyLong())).thenReturn(accountTest);
		 
	   Assert.assertEquals (accountService.makeWithdrawal(accountMockedService.getAccountById(22L), 800f), Constants.SUCCESSFUL_WITHDRAWAL);
			
	}
	
	/** ###################################################################### **/
	/** Test cases to build the deposit Functionality **/
	/** ###################################################################### **/
	
	@Test
	public void makeDepositNegativeAmount()
	{  		 
	  Assert.assertEquals (accountService.makeADeposit(accountMockedService.getAccountById(22L),-1f), Constants.INVALID_AMOUNT);			
	}
	
	@Test
	public void makeDepositZeroAmount()
	{  		 
	  Assert.assertEquals (accountService.makeADeposit(accountMockedService.getAccountById(22L),0f), Constants.INVALID_AMOUNT);			
	}
	
	@Test
	public void makeDepositSuccess()
	{  		 
	  Assert.assertEquals (accountService.makeADeposit(accountMockedService.getAccountById(22L), 100f), Constants.SUCCESSFUL_DEPOSIT );			
	}
	
	/** ###################################################################### **/
	/** Test cases to build the get Operations Functionality **/
	/** ###################################################################### 
	 * @throws Exception **/
	
	@Test
	public void getOperationsSuccess() throws Exception
	{  		 
		Account a1 =  accountMockedService.getAccountById(22L);
		accountService.makeADeposit(a1, 22f);
		List<String> operations = accountService.getAccountsLastOperations(a1);
		 Assert.assertNotNull(operations.get(0));		
	}
	@Test
	public void getOperationsWithInvalidCustomer() 
	{  		 
		Account a1 =  accountMockedService.getAccountById(22L);
		accountService.makeADeposit(a1, 22f);
		a1.setCustomerId(null);
		try {
			accountService.getAccountsLastOperations(a1);
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), Constants.INVALID_CUSTOMER);
		}
			
	}
	
	@Test
	public void getOperationsWithInvalidAccount() 
	{  		 
		Account a1 =  accountMockedService.getAccountById(22L);
		accountService.makeADeposit(a1, 22f);
		a1 = null;
		try {
			accountService.getAccountsLastOperations(a1);
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), Constants.INVALID_ACCOUNT);
		}
			
	}
	
	
}
