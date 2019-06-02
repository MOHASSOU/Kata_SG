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
	
	 //
	 // Given
	 //
	 Customer customer = customerService.createCustomer("firstNameTest", "lastNameTest", "addressTest");	
	 
	 //
	 // When
	 //
	 String firstName = customer.getFirstName();
	 String lastName = customer.getLastName() ;
	 String address = customer.getAddress();
	 
	 //
	 // Then
	 //
	 Assert.assertEquals (firstName, "firstNameTest" );
	 Assert.assertEquals (lastName, "lastNameTest" );
	 Assert.assertEquals (address, "addressTest" );
	}
	
	@Test
	public void createCustomerInvalidParameters() 
	{  
	//
	// When
	//
	try {
		customerService.createCustomer(null, null, null);
	} 
	
	//
	// Then
	//
	catch (Exception e) {
		Assert.assertEquals (e.getMessage(), Constants.NULL_OR_INVALID_INFORMATION );
	}	
	 
	}
	
}
