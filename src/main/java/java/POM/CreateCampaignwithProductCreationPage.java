package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignwithProductCreationPage {
	public CreateCampaignwithProductCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(xpath="/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")
	private WebElement createproductimage;
	
	@FindBy(name="productname")
	private WebElement productnametext;
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createcampaignimage;
	
	@FindBy(name="campaignname")
	private WebElement campaignnametext;
	
	@FindBy(xpath="/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[4]/img")
	private WebElement selectdropdown;
	
	@FindBy(id="search_txt")
	private WebElement searchbox;
	
	@FindBy(name="search")
	private WebElement searchbutton;
	
	@FindBy(xpath="/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")
    private WebElement savebutton;

//getters methods

public WebElement getCreateproductimage() {
	return createproductimage;
}

public WebElement getProductnametext() {
	return productnametext;
}

public WebElement getCreatecampaignimage() {
	return createcampaignimage;
}

public WebElement getCampaignnametext() {
	return campaignnametext;
}

public WebElement getSelectdropdown() {
	return selectdropdown;
}

public WebElement getSearchbox() {
	return searchbox;
}

public WebElement getSearchbutton() {
	return searchbutton;
}

public WebElement getSavebutton() {
	return savebutton;
}

//business logic

public void createproductimage()
{
	createproductimage.click();
}
public void productnametext(String proname)
{
	productnametext.sendKeys(proname);
}
public void createcampaignimage()
{
	createcampaignimage.click();

}
public void campaignnametext(String camname)
{
	campaignnametext.sendKeys(camname);
}
public void selectdropdown()
{
	selectdropdown.click();
}
public void searchbox(String data)
{
	searchbox.sendKeys(data);
}
public void searchbutton()
{
	searchbutton.click();
}

public void savebutton()
{
	savebutton.click();
}
}








