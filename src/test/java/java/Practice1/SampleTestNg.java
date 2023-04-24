package Practice1;

import org.testng.annotations.Test;


public class SampleTestNg {
	
	
	@Test(invocationCount=3)
	public void createContact()
	{
		System.out.println("Contact created");

	
	}
	
	@Test
	public void modifyContact()
	{
		System.out.println("Contact modified");
	}
	@Test
	public void deleteContact()
	{
		System.out.println("Contact deleted");

	}
	

}
