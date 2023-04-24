package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage {
	public ValidationAndVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='dtlview_Product Name']")
	private WebElement actualProductData;

	
	//getter Method
	public WebElement getActualProductData() {
		return actualProductData;
	}
	
	//business logics
	public String productValidation(WebDriver driver,String data)
	{
		String actData=actualProductData.getText();
		
		if(actData.contains(data))
		{
			System.out.print("pass");
		}
		else
		{
			System.out.print("fail");
		}
		return actData;
	}

}
