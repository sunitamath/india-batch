package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationandVerificationPage2 {
	
	public  ValidationandVerificationPage2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span[class=dvHeaderText]")
	private WebElement actualorgname;
	
	
	@FindBy(xpath="span[@class='dvHeaderText']")
	private WebElement actualCampname;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement actualproname;
	
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement actcampname;
	
	@FindBy(xpath="//span[@id='dtlview_Product']")
	private WebElement actproname;
	
	
	
	
	//getters
	
	public WebElement getActualorgname() {
		return actualorgname;
	}

	public WebElement getActualCampname() {
		return actualCampname;
	}

	public WebElement getActualproname() {
		return actualproname;
	}

	public WebElement getActcampname() {
		return actcampname;
	}

	public WebElement getActproname() {
		return actproname;
	}

	
	//Business logic
	
	public void ValidationandVerificationoforganization (WebDriver driver,String data)
	{
		String actData=actualorgname.getText();
		
		if(actData.contains(data))
		{
			System.out.print("pass");
		}
		else
		{
			System.out.print("fail");
		}
	}
	
	public void productValidationofCampaign(WebDriver driver,String data)
	{
		String actData=actualCampname.getText();
		
		if(actData.contains(data))
		{
			System.out.print("pass");
		}
		else
		{
			System.out.print("fail");
		}
	}
	public void productValidationofProduct(WebDriver driver,String data)
	{
		String actData=actualproname.getText();
		
		if(actData.contains(data))
		{
			System.out.print("pass");
		}
		else
		{
			System.out.print("fail");
		}
	}
	public String ValidationandVerificationCampaignAddition(WebDriver driver,String data)
	{
		String act=actcampname.getText();
		if(act.contains(data))
		{
			System.out.println("Campaign Pass");
		}
		else
		{
			System.out.println("Campaign Pass");
		}
		return act;

		}
		
		public String ValidationandVerificationProductAddition(WebDriver driver,String data)
		{
			String actData=actproname.getText();
			if(actData.contains(data))
			{
				System.out.println("Product Pass");
			}
			else
			{
				System.out.println("Product Fail");

			}
			return actData;
	}

}
