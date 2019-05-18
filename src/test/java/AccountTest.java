package test.java;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import junit.framework.Assert;
import main.java.beans.Account;
import main.java.transverse.Constants;
import services.Service;

public class AccountTest {

	ApplicationContext appContext = new FileSystemXmlApplicationContext("src/main/resources/app-context.xml");
	Service accountService = appContext.getBean("service", Service.class);

	private Account accountTest;
	 
	 
	@org.junit.Before
	public void initTest() 
	{
	    accountService = Mockito.mock(Service.class);
	}
	 
	 
	@SuppressWarnings("deprecation")
	@Test
	public void makeWithdrawalBalaceExcessFailure()
	{
	   accountTest  = new Account(1L, 300f);
	   accountTest.setBalance(500f);
	
	   Mockito.when(accountService.getAccount(Mockito.anyLong())).thenReturn(accountTest);
	 
	   Assert.assertEquals (accountService.getAccount(22L).makeWithdrawal(801f), Constants.INSUFFICIENT_BLANCE);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void makeWithdrawalSuccess()
	{
	   Account accountTest = new Account(2L, 300f);
	   accountTest.setBalance(500f);
	   Mockito.when(accountService.getAccount(Mockito.anyLong())).thenReturn(accountTest);
		 
	   /**Mettre des messages dans des fichiers propriétés  **/
	   Assert.assertEquals (accountService.getAccount(22L).makeWithdrawal(499f), Constants.SUCCESSFUL_WITHDRAWAL);
			
	}
}
