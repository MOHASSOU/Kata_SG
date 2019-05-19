package test.java;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import junit.framework.Assert;
import main.java.beans.Account;
import main.java.beans.Customer;
import main.java.transverse.Constants;
import services.Service;

public class CustomerTest {

	ApplicationContext appContext = new FileSystemXmlApplicationContext("src/main/resources/app-context.xml");
	Service accountService = new Service();
	/** ###################################################################### **/
	/** Test cases to build the create Customer Functionality **/
	/** ###################################################################### 
	 * @throws Exception **/
	
	@SuppressWarnings("deprecation")
	@Test
	public void createCustomerSuccess() throws Exception
	{  	
	
	 Customer customer = accountService.createCustomer("firstNameTest", "lastNameTest", "addressTest");	
	 Assert.assertEquals (customer.getFirstName(), "firstNameTest" );
	 Assert.assertEquals (customer.getLastName(), "lastNameTest" );
	 Assert.assertEquals (customer.getAddress(), "addressTest" );
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void createCustomerInvalidParameters() 
	{  	
	try {
		accountService.createCustomer(null, null, null);
	} catch (Exception e) {
		Assert.assertEquals (e.getMessage(), Constants.NULL_OR_INVALID_INFORMATION );
	}	
	 
	}
	
}
