package test.java;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import junit.framework.Assert;
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
	    accountTest = new Account(1L, 300f);
		Mockito.when(accountMockedService.getAccountById(Mockito.anyLong())).thenReturn(accountTest);
	}
	 
	
	/** ###################################################################### **/
	/** Test cases to build the Withdrawal Functionality **/
	/** ###################################################################### **/
	
	@SuppressWarnings("deprecation")
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
	
	@SuppressWarnings("deprecation")
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
	
	
}
