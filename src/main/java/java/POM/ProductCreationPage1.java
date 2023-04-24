package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreationPage1 {
	public ProductCreationPage1(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
//declaration
	@FindBy(xpath="/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")
	private WebElement ProductCreateImage;
	
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath="/html/body/table[4]/tbody/tr/td[2]/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[31]/td/div/input[1]")
	private	WebElement saveButton;

	
	//getter Methods
	public WebElement getProductCreateImage() {
		return ProductCreateImage;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This Method is used for ClickOn +img
	 * 
	 */
	public void clickProductCreateImage()
	{
		ProductCreateImage.click();
	}
	/**
	 * This method is used to pass value to ProductTextField
	 * 
	 */
	public void namesTextField(String orgName)
	{
		productNameTextField.sendKeys(orgName);
	}
	/**
	 * This Method is used to Save ProName
	 */
	public void saveButton()
	{
		
		saveButton.click();
	}
			
}
	

	
	
	



