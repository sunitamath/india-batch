package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
}
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement orgLinkText;
	
	@FindBy(linkText="Products")
	private WebElement proLinkText;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campLinkText;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLinkText;

//getters methods
	public WebElement getOrgLinkText() {
		return orgLinkText;
	}


	public WebElement getProLinkText() {
		return proLinkText;
	}


	public WebElement getMoreTab() {
		return moreLink;
	}


	public WebElement getCampLinkText() {
		return campLinkText;
	}


	public WebElement getSignoutimg() {
		return signoutimg;
	}


	public WebElement getSignOutLinkText() {
		return signOutLinkText;
	}

	//Business Logic for Product
	
	public void clickProLink()
	{
		proLinkText.click();
	}
	
	//Business Logic for organization
	public void clickorgLink()
	{
		orgLinkText.click();
	}
	
		//Business Logic for campaign
	public void clickcampLink()
	{
		campLinkText.click();
	}
	//		Business Logic for more
	public void moreLink(WebDriver driver)
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.mouseOverOnElement(driver,moreLink);
	}
// sign out
	public void signoutLink(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(signoutimg).perform();
		signOutLinkText.click();
	}

}	
	
	
	


	

	
	


	
	