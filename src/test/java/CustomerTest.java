package test.java;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import org.junit.Assert; 
import main.java.beans.Customer;
import main.java.transverse.Constants;
import services.CustomerService;

public class CustomerTest {

	ApplicationContext appContext = new FileSystemXmlApplicationContext("src/main/resources/app-context.xml");
	CustomerService customerService = appContext.getBean("customerService", CustomerService.class);
	
	
	/** ###################################################################### **/
	/** Test cases to build the create Customer Functionality **/
	/** ###################################################################### 
	 * @throws Exception **/
	
	@Test
	public void createCustomerSuccess() throws Exception
	{  	
	
	 Customer customer = customerService.createCustomer("firstNameTest", "lastNameTest", "addressTest");	
	 Assert.assertEquals (customer.getFirstName(), "firstNameTest" );
	 Assert.assertEquals (customer.getLastName(), "lastNameTest" );
	 Assert.assertEquals (customer.getAddress(), "addressTest" );
	}
	
	@Test
	public void createCustomerInvalidParameters() 
	{  	
	try {
		customerService.createCustomer(null, null, null);
	} catch (Exception e) {
		Assert.assertEquals (e.getMessage(), Constants.NULL_OR_INVALID_INFORMATION );
	}	
	 
	}
	
}
