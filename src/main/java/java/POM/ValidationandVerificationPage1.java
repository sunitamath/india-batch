package POM;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ValidationandVerificationPage1 {
		public ValidationandVerificationPage1(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css="span.dvHeaderText")
		private WebElement actualCampData;

		
		
		//getters Methods
		public WebElement getActualCampData() {
			return actualCampData;
		}




		//business logics
		public void campaignValidation(WebDriver driver,String data)
		{
			String actData=actualCampData.getText();
			
			if(actData.contains(data))
			{
				System.out.print("pass");
			}
			else
			{
				System.out.print("fail");
			}
		}

	}



