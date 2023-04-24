package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreationPage1 {
	
	public OrganizationCreationPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//Declaration
	@FindBy(xpath="/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")
	private WebElement organizationCreateImage;
	
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(xpath="/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[22]/td/div/input[1]")
	private	WebElement saveButton;

	
	//getters Methods
	
	public WebElement getOrganizationCreateImage() {
		return organizationCreateImage;
	}

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}	
	
	/**
	 * This Method is used for ClickOn +img
	 */
	public void clickOrganizationCreateImage()
	{
		organizationCreateImage.click();
	}
	
	/**
	 * This method is used to pass value to OrganizationTextField
	 * 
	 */
	public void organizationnamesTextField(String orgName)
	{
		organizationNameTextField.sendKeys(orgName);
	}
	/**
	 * This Method is used to Save OrgName
	 */
	public void saveButton()
	{
		
		saveButton.click();
	}
			
}
