package Practice1;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void createContact()
	{
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(false,false);
		System.out.println("step4");
		System.out.println("step5");
		soft.assertAll();
	}
		

		
		@Test
		public void m1()
		{
			String expData="qspiders";
			String actData="qspiders";
			Assert.assertEquals(actData,expData);
			SoftAssert soft=new SoftAssert();
			soft.assertEquals(actData,expData);
			soft.assertAll();

			
		}
}
		




	


		
	


