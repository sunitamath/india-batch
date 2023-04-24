package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreationPage1 {
	public CampaignCreationPage1(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath=("//img[@alt='Create Campaign...']"))
	private WebElement CampaignCreateImage;
	@FindBy(name="campaignname")
	private WebElement CampaignNameTextField;
	@FindBy(xpath=("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]"))
	private WebElement saveButton;
	
	
	
	//getters methods

	public WebElement getCampaignCreateImage() {
		return CampaignCreateImage;
	}

	public WebElement getCampaignNameTextField() {
		return CampaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	//Business logic
	
		/**
		 * This Method is used for ClickOn +img
		 */
		public void clickCampaignCreateImage()
		{
			CampaignCreateImage.click();
		}
		
	/**
	 * This method is used to pass value to CampaignTextField
	 * 
	 */
	public void campaignnamesTextField(String campName)
	{
		CampaignNameTextField.sendKeys(campName);
	}
	/**
	 * This Method is used to Save CampName
	 */
	public void saveButton()
	{
		
		saveButton.click();
	}
			
	
	
	
			

}
