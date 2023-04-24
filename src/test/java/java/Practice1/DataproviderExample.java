package Practice1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;

public class DataproviderExample {
	@Test(dataProvider="dataProvider")
	public void booktickets(String src,String des)
	{
		System.out.println("Book tickets from "+src+ "to" +des);
	}
	@DataProvider
	public Object[][] dataProvider() 
	{
		Object[][] objarr=new Object[3][2];
		
		objarr[0][0]="Banglore";
		objarr[0][1]="Hubli";
		
		objarr[1][0]="Banglore";
		objarr[1][1]="Mysore";

		objarr[2][0]="Banglore";
		objarr[2][1]="Hyd";
		
		return objarr;

	}
}
