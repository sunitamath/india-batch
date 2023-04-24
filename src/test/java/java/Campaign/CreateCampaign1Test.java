package Campaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.WebDriver_Utility;
import POM.CampaignCreationPage1;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationCreationPage1;
import POM.ValidationandVerification;
import POM.ValidationandVerificationPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaign1Test extends BaseClass {
	
	@Test(groups="smoketest")
	public  void  CreateCampaign1()throws Throwable{
		
		//System.setProperty("webdriver.http.factory", "jdk-http-client");
		//System.setProperty("webdriver.chrome.driver","D:/Sunita/Selenium Advance/chromedriver/chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
	
			Property_Utility plib=new Property_Utility();
			//String BROWSER = plib.getKeyValue("browser");
			
			//WebDriver driver;
		
		//if(BROWSER.equalsIgnoreCase("chrome"))
		/*{
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
		}*/
		driver.manage().window().maximize();
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.implicitlyWait(driver);
	   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// String URL = plib.getKeyValue("url");
		  //  String USERNAME = plib.getKeyValue("username");
		  // String PASSWORD = plib.getKeyValue("password");
		   
		   /*FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
			
			Properties pro=new Properties();
			pro.load(fis);
			String URL = pro.getProperty("url");
			String USERNAME = pro.getProperty("username");
			String PASSWORD = pro.getProperty("password");*/
		   
		 //  driver.get(URL);
		 
		   /* driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();*/
		   
		  // LoginPage loginPage=new LoginPage (driver);
			//loginPage.loginToApp(USERNAME, PASSWORD);
			//loginPage.getSubmitBtn().click();
			
			
			
			HomePage home=new HomePage(driver);
			home.moreLink(driver);
			home.clickcampLink();
			
			//driver.findElement(By.linkText("Campaign")).click();
			
			CampaignCreationPage1 camp=new CampaignCreationPage1(driver);
			camp.clickCampaignCreateImage();
			//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			
			/*Random ran=new Random();
			int RanNum=ran.nextInt(1000);*/
			
			Java_Utility jlib=new Java_Utility();
			int RanNum = jlib.getRandomNum();
			
			Excel_Utility elib=new Excel_Utility();
			String Campdata = elib.getExcelData("Campagin", 1,2)+RanNum;
			
			/*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
			Workbook book = WorkbookFactory.create(fes);
			Sheet sheet = book.getSheet("Organization");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(1);
			String exceldata = cell.getStringCellValue()+RanNum;*/
			
			camp.campaignnamesTextField(Campdata);
			//driver.findElement(By.name("campaignname")).sendKeys(exceldata);
			
			camp.saveButton();
			//driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")).click();

			ValidationandVerificationPage1 validate=new ValidationandVerificationPage1(driver);
			validate.campaignValidation(driver, Campdata);
			
			
			/*String actdata = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
			if(actdata.contains(exceldata))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}*/
			
			
			//home.signoutLink(driver);
			
			//driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
			//driver.findElement(By.linkText("Sign Out")).click();
		}

		
		}




		


		



