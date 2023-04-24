package Campaign;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.WebDriver_Utility;
import POM.CreateCampaignwithProductCreationPage;
import POM.HomePage;
import POM.LoginPage;
import POM.ValidationAndVerificationPage;
import POM.ValidationandVerificationPage1;
import POM.ValidationandVerificationPage2;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignwithProduct1 {

	


public static void main(String[] args) throws Throwable {
		
		//System.setProperty("webdriver.http.factory", "jdk-http-client");
		//System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
				
				//ChromeDriver driver = new ChromeDriver();
				
	
	
	WebDriver driver;
	Property_Utility plib=new Property_Utility();
	String BROWSER = plib.getKeyValue("browser");
	

if(BROWSER.equalsIgnoreCase("chrome"))
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
else if(BROWSER.equalsIgnoreCase("edge"))
{
	WebDriverManager.chromedriver().setup();
	driver=new EdgeDriver();
}
else if (BROWSER.equalsIgnoreCase("firefox"))
{
	WebDriverManager.chromedriver().setup();
	driver=new FirefoxDriver();
}
else
{
	driver=new ChromeDriver();
}				
	
	
	
	
driver.manage().window().maximize();
	WebDriver_Utility wlib=new WebDriver_Utility();
				wlib.implicitlyWait(driver);
 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				
			//	Property_Utility plib=new Property_Utility();
			//	plib.getKeyValue(BROWSER)

	
	
				//FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
				//Properties pro=new Properties();
				//pro.load(fis);
				String URL = plib.getKeyValue("url");
				String USERNAME = plib.getKeyValue("username");
				String PASSWORD = plib.getKeyValue("password");

				driver.get(URL);
			
				
				//driver.get("http://localhost:8888/");
				
				LoginPage LoginPage=new LoginPage(driver);
				LoginPage.loginToApp(USERNAME, PASSWORD);
				
				//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				//driver.findElement(By.id("submitButton")).click();
				
				HomePage home=new HomePage(driver);
				home.getProLinkText();
				
				//driver.findElement(By.linkText("Products")).click();
				
				CreateCampaignwithProductCreationPage ccpcp=new CreateCampaignwithProductCreationPage(driver);
				ccpcp.getCreateproductimage();
				//driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
				
				//Random ran=new Random();
				//int RanNum=ran.nextInt(1000);
				
				Java_Utility jlib=new Java_Utility();
				int RanNum=jlib.getRandomNum();		
				
				
				
				Excel_Utility elib=new Excel_Utility();
				String productdata = elib.getExcelData("product",1,1)+RanNum;
				
				/*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
				Workbook book = WorkbookFactory.create(fes);
				 Sheet sheet = book.getSheet("Product");
				Row row = sheet.getRow(1);
				Cell cell = row.getCell(1);
				String productdata = cell.getStringCellValue()+RanNum;*/
				
				ccpcp.productnametext(productdata);
				
				//driver.findElement(By.name("productname")).sendKeys(productdata);
				
				ccpcp.getSavebutton();
				
				//driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[31]/td/div/input[1]")).click();
				
				
				home.moreLink(driver);
				home.clickcampLink();
				ccpcp.createcampaignimage();
				
				//driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[22]")).click();
				//driver.findElement(By.linkText("Campaigns")).click();
				
				//driver.findElement(By.xpath	("//img[@alt='Create Campaign...']")).click();
				
				
				String CampData=elib.getExcelData("Campagin",1,2)+RanNum;
				 
				/*FileInputStream fes1=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
				Workbook book1 = WorkbookFactory.create(fes1);
				 Sheet sheet1 = book1.getSheet("Campagin");
				Row row1 = sheet1.getRow(1);
				Cell cell1 = row1.getCell(2);
				String CampData = cell1.getStringCellValue()+RanNum;*/
				
				ccpcp.campaignnametext(CampData);
				
				//driver.findElement(By.name("campaignname")).sendKeys(CampData);
				
				ccpcp.selectdropdown();
				//driver.findElement(By.xpath	("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[4]/img")).click();
				
				wlib.switchwindow(driver,"Products&action");
				
				/*Set<String>allid = driver.getWindowHandles();
				Iterator<String> id = allid.iterator();
				
				while(id.hasNext())
				{
					String wid = id.next();
					driver.switchTo().window(wid);
					String title = driver.getTitle();
					
					if(title.contains("Products&action"))
					{
						break;
					}
				}*/
				
				ccpcp.searchbox(productdata);
				//driver.findElement(By.id("search_txt")).sendKeys(productdata);
				ccpcp.getSearchbutton();
					//driver.findElement(By.name("search")).click();
					
					
					//dynamic xpath
					driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
					
					wlib.switchwindow(driver," Campaigns&action");
					
					/*Set<String>allid1 = driver.getWindowHandles();
					Iterator<String> id1 = allid1.iterator();
					
					while(id1.hasNext())
					{
						String wid1 = id1.next();
						driver.switchTo().window(wid1);
						String title1 = driver.getTitle();
						
						if(title1.contains("Campaigns&action"))
						{
							break;
						}
				
					}*/	// TODO Auto-generated method stub
					
					ccpcp.savebutton();
				//driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")).click();
					
					
				//	ValidationandVerificationPage1 validate=new ValidationandVerificationPage1(driver);
				//	validate.campaignValidation(driver, Campdata);
					
				//	ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
				//	validate.productValidation(driver, exceldata);
					
					
					
					ValidationandVerificationPage2 validate=new ValidationandVerificationPage2(driver);
			Sring CampData1=Validate.ValidationandVerificationofCampaignAddition(driver,CampData1);
		String productdata1=Validate.ValidationandVerificationofProductAddition(driver,productdata1);
					
					
					
					//String act = driver.findElement(By.xpath("//*[@id=\"dtlview_Campaign Name\"]")).getText();
					//if(act.contains(CampData))
					//{
						//System.out.println("camp pass");
					//}
					//else
					//{
						//System.out.println("camp fail");
					//}
					
					//String actData = driver.findElement(By.xpath("//*[@id=\"mouseArea_Product\"]")).getText();
					//if(actData.contains(productdata))
					//{
						//System.out.println("prod pass");
					//}
					//else
					//{
						//System.out.println("prod fail");
					//}
					
					home.signoutLink(driver);
					
					//driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
					//driver.findElement(By.linkText("Sign Out")).click();
					
	}		
		// TODO Auto-generated method stubs

	
}



