package product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.WebDriver_Utility;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationCreationPage1;
import POM.ProductCreationPage1;
import POM.ValidationAndVerificationPage;
import POM.ValidationandVerification;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct1Test extends BaseClass {
	
	@Test(groups={"smoketest","regressiontest","sanitytest"})
	public void CreateProduct1() throws Throwable{
		
		//System.setProperty("webdriver.http.factory", "jdk-http-client");
		//System.setProperty("webdriver.chrome.driver","D:/Sunita/Selenium Advance/chromedriver/chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		
			Property_Utility plib=new Property_Utility();
			//String BROWSER = plib.getKeyValue("browser");
			
		//	WebDriver driver;
		
		//if(BROWSER.equalsIgnoreCase("chrome"))
		//{
			//WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
		//}
		//else if(BROWSER.equalsIgnoreCase("edge"))
		//{
			//WebDriverManager.chromedriver().setup();
			//driver=new EdgeDriver();
		//}
		//else if (BROWSER.equalsIgnoreCase("firefox"))
		//{
			//WebDriverManager.chromedriver().setup();
			//driver=new FirefoxDriver();
		//}
		//else
		//{
			//driver=new ChromeDriver();
		//}
		driver.manage().window().maximize();
		
		WebDriver_Utility wlib=new WebDriver_Utility();
	wlib.implicitlyWait(driver);
	   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		 //String URL = plib.getKeyValue("url");
		   // String USERNAME = plib.getKeyValue("username");
		  // String PASSWORD = plib.getKeyValue("password");
		   
		   /*FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
			
			Properties pro=new Properties();
			pro.load(fis);
			String URL = pro.getProperty("url");
			String USERNAME = pro.getProperty("username");
			String PASSWORD = pro.getProperty("password");*/
		   
		  // driver.get(URL);
		 
		   /* driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();*/
		   
		   //LoginPage loginPage=new LoginPage (driver);
			//loginPage.loginToApp(USERNAME, PASSWORD);
			//loginPage.getSubmitBtn().click();
			
			HomePage home=new HomePage(driver);
			home.clickProLink();
			//driver.findElement(By.linkText("Products")).click();
			
			ProductCreationPage1 pro=new ProductCreationPage1(driver);
			pro.clickProductCreateImage();
			//driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
			
			/*Random ran=new Random();
			int RanNum=ran.nextInt(1000);*/
			
			Java_Utility jlib=new Java_Utility();
			int RanNum = jlib.getRandomNum();
			
			Excel_Utility elib=new Excel_Utility();
			String exceldata = elib.getExcelData("Product", 1,1)+RanNum;
			
			/*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
			Workbook book = WorkbookFactory.create(fes);
			Sheet sheet = book.getSheet("Product");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(1);
			String exceldata = cell.getStringCellValue()+RanNum;*/
			
			pro.namesTextField(exceldata);
			//driver.findElement(By.name("productname")).sendKeys(exceldata);
			
			pro.saveButton();
			//driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[31]/td/div/input[1]")).click();

			ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
			 String actData= validate.productValidation(driver, exceldata);
			 
			 Assert.assertEquals(actData, exceldata);
			
			
			/*String actdata = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
			if(actdata.contains(exceldata))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}*/
			
			
			home.signoutLink(driver);
			
			//driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
			//driver.findElement(By.linkText("Sign Out")).click();
		}

		
		}
			



