package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationandVerification {
	public ValidationandVerification(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="span.dvHeaderText")
	private WebElement actualOrganizationData;

	//getter method
	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}
	
	//business logics
	
	public String organizationValidation(WebDriver driver,String data)
	{
	String actdata = actualOrganizationData.getText();
	if(actdata.contains(data))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	return actdata;
	}
}
	

	
	
			


